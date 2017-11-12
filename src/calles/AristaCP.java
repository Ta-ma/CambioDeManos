package calles;

public class AristaCP {
    private int numArista;
    private int padre;
    
    public AristaCP(int numArista, int padre) {
	super();
	this.numArista = numArista;
	this.padre = padre;
    }

    public int getNumArista() {
        return numArista;
    }

    public void setNumArista(int numArista) {
        this.numArista = numArista;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }
    
}
