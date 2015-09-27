package tp2.exercises;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import tp2.Excercise2.VerticeAdyacente;

public class BFS{

	private class NodoConRecorrido{
		int nodo;
		int recorridoActual;

		public NodoConRecorrido(int nodo, int recorridoActual){
			this.recorridoActual = recorridoActual;
			this.nodo = nodo;
		}

		public int getNodo(){
			return nodo;
		}

		public int getRecorrido(){
			return recorridoActual;
		}
	}

	private boolean recorridos[];
	private List< List<VerticeAdyacente> > vertices;

	public BFS(List< List<VerticeAdyacente> > vertices){
		recorridos    = new boolean[ vertices.size() ];
		this.vertices = vertices; 
	}

	public int buscarCaminoMinimo(){
		NodoConRecorrido actual      = new NodoConRecorrido(0, 0);
		Queue<NodoConRecorrido> cola = new LinkedList<NodoConRecorrido>();
		int caminoMinimo = Integer.MAX_VALUE;

		cola.add(actual);

		while (!cola.isEmpty()) {
			actual = cola.poll();

			for( VerticeAdyacente l : vertices.get(actual.getNodo()) ) {
				int pesoParcial = actual.getRecorrido() + l.getPeso();
				int nodoActual  = l.getNodo();

				NodoConRecorrido proximo = new NodoConRecorrido(nodoActual, pesoParcial);

				if ( !esUltimo(nodoActual) && !pase(nodoActual)) {
					cola.add(proximo);
				} else if ( esUltimo(nodoActual) ) {
					if (pesoParcial < caminoMinimo) {
						caminoMinimo = pesoParcial;
					}
				}

			}
		}

		return caminoMinimo;
	}

	private boolean pase(int nodo){
		boolean result = recorridos[nodo];

		recorridos[nodo] = true;

		return result;
	}

	private boolean esUltimo(int nodo){
		return nodo == vertices.size() - 1;
	}
}