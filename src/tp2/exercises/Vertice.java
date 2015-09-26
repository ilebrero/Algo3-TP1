package tp2.exercises;

public class Vertice {
	private int nodo1;
	private int nodo2;
	private int peso;
	
	public Vertice(int nodo1,int nodo2,int peso) {
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
		this.peso = peso;
	}
	
	public int getNodo1() {
		return nodo1;
	}
	
	public int getNodo2() {
		return nodo2;
	}
	
	public int getPeso() {
		return peso;
	}
	public int compareTo(Vertice other) {
		if (other.getPeso() < this.getPeso()) {
			return 1;
		} else if (other.getPeso() > this.getPeso()){
			return -1;
		}
		return 0;
	}
}