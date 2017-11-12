package calles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Grafo {

    public static final int NG = 9999;
    private int nodoEscuela;
    private int nodoPartida;
    private int cantNodos;
    Map<Integer, Nodo> nodos;
    Map<Integer,Arista> aristasOriginales;
    List<Arista> caminoInverso;
    
    public Grafo(File arch) throws IOException {
	Scanner sc = new Scanner(arch);
	
	nodos = new HashMap<Integer, Nodo>();
	cantNodos = sc.nextInt();
	nodoPartida = sc.nextInt();
	nodoEscuela = sc.nextInt();
	int cantAristas = sc.nextInt();
	aristasOriginales = new HashMap<Integer, Arista>();
	caminoInverso = new LinkedList<Arista>();
	
	for (int i = 0; i < cantNodos; i++) {
	    nodos.put(i + 1, new Nodo(i));
	}
	
	for (int i = 0; i < cantAristas; i++) {
	    int nodoO = sc.nextInt();
	    int nodoD = sc.nextInt();
	    int largo = sc.nextInt();
	    Arista arista = new Arista(i + 1, nodoO, nodoD, largo);
	    
	    aristasOriginales.put(i + 1, arista);
	    nodos.get(nodoO).agregarArista(arista);
	    System.out.println(nodoD);
	    nodos.get(nodoD).agregarArista(new Arista(i + 1, nodoD, nodoO, largo));
	}
	
	/*for (int i = 0; i < cantNodos; i++) {
	    System.out.println(nodos.get(i + 1));
	}
	
	for (int i = 0; i < cantAristas; i++) {
	    System.out.println(aristasOriginales.get(i));
	}*/
	
	sc.close();
    }
    
    public void resolver () {
	int[] costos = new int[cantNodos];
	AristaCP[] padres = new AristaCP[cantNodos];
	Queue<NodoCC> cola = new PriorityQueue<NodoCC>();
	Set<Integer> v = new HashSet<Integer>();
	
	for (int i = 0; i < cantNodos; i++) {
	    costos[i] = NG;
	    padres[i] = new AristaCP(0, 0);
	}
	
	List<Arista> aristas = new LinkedList<Arista>();
	cola.add(new NodoCC(nodoPartida, 0));
	
	while(!cola.isEmpty()) {
	    NodoCC nodoCC = cola.poll();
	    v.add(nodoCC.getNodo());
	    aristas = nodos.get(nodoCC.getNodo()).getAristas();
	    
	    for(Arista a : aristas) {
		int nodoD = a.getNodoD();
		int largo = a.getLargo();
		
		if (!v.contains(nodoD) && costos[nodoD - 1] > nodoCC.getCosto() + largo) {
		    costos[nodoD - 1] = nodoCC.getCosto() + largo;
		    //padres[nodoD - 1] = nodoCC.getNodo() - 1;
		    padres[nodoD - 1] = new AristaCP(a.getNum(), nodoCC.getNodo());
		    cola.add(new NodoCC(nodoD, costos[nodoD - 1]));
		}
	    }
	}
	
	/*System.out.println("costos");
	for (int i = 0; i < cantNodos; i++) {
	    System.out.print(costos[i] + " ");
	}
	System.out.println();
	System.out.println("padres");
	for (int i = 0; i < cantNodos; i++) {
	    System.out.print((padres[i]) + " ");
	}
	System.out.println();*/
	
	System.out.println(costos[nodoEscuela - 1]);
	
	//reconstruyo el camino inverso
	AristaCP aristaPadre = padres[nodoEscuela - 1];
	int nodoAnterior = nodoEscuela;
	while(aristaPadre.getPadre() != nodoPartida) {
	    caminoInverso.add(new Arista(aristaPadre.getNumArista(), aristaPadre.getPadre(), nodoAnterior, 0));
	    aristaPadre = padres[aristaPadre.getPadre() - 1];
	    nodoAnterior = aristaPadre.getPadre();
	}
	
	// me fijo cuales tienen manos cambiadas
	for(Arista a : caminoInverso) {
	    Arista aristaOriginal = aristasOriginales.get(a.getNum());
	    if (a.getNodoO() != aristaOriginal.getNodoO()) {
		System.out.print(a.getNum() + " ");
	    }
	}
    }

}
