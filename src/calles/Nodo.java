package calles;

import java.util.LinkedList;
import java.util.List;

public class Nodo {
    private int id;
    private List<Arista> aristas;
    
    public Nodo(int id) {
	this.id = id;
	aristas = new LinkedList<Arista>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }

    public void agregarArista(Arista arista) {
	this.aristas.add(arista);
    }

    @Override
    public String toString() {
	return "Nodo [id=" + id + ", aristas=" + aristas + "]";
    }
}
