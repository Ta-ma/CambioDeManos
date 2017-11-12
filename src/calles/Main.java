package calles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
	File dir = new File(".//IN//");
	generarFatiga(new File(".//IN//fatiga.in"));
	for(File arch : dir.listFiles()) {
	    
	    Grafo grafo = new Grafo(arch);
	    grafo.resolver();
	}

    }
    
    public static void generarFatiga(File arch) throws IOException {
	final int NODOS = 80000;
	final int ARISTAS = 250000;
	PrintWriter out = new PrintWriter(new FileWriter(arch));
	Random ran = new Random();
	out.print(NODOS);
	out.print(" ");
	out.print(1);
	out.print(" ");
	out.println(NODOS);
	out.println(ARISTAS);
	
	for(int i = 0; i < ARISTAS; i++) {
	    out.print((i % NODOS) + 1);
	    out.print(" ");
	    out.print(((((i + 1) % NODOS) + 1 + (i / NODOS)) % NODOS) + 1);
	    out.print(" ");
	    out.println(ran.nextInt(50) + 1);
	}
	
	out.close();
    }

}
