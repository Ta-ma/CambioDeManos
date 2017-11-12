package calles;

public class Arista {
    private int num;
    private int nodoO;
    private int nodoD;
    private int largo;
    
    public Arista(int num, int nodoO, int nodoD, int largo) {
	super();
	this.num = num;
	this.nodoO = nodoO;
	this.nodoD = nodoD;
	this.largo = largo;
    }

    public int getNodoO() {
        return nodoO;
    }

    public void setNodoO(int nodoO) {
        this.nodoO = nodoO;
    }

    public int getNodoD() {
        return nodoD;
    }

    public void setNodoD(int nodoD) {
        this.nodoD = nodoD;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
	return "Arista [nodoO=" + nodoO + ", nodoD=" + nodoD + ", largo=" + largo + "]";
    }
    
}
