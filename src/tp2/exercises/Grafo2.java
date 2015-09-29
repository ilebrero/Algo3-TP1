package tp2.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import sun.misc.Queue;


public class Grafo2 {
	
	private Map<String, Nodo> nodos;
	private int idVertices;
	private int peso;
	private int nodoFantasma = 0;
	public Grafo2(List<Portal<Baldoza>> portales) {
		nodos = new HashMap<String,Nodo>();
		idVertices = 0;
		peso = 0;
		for (int i = 0; i < portales.size() - 1; i++) {
			Portal portal = portales.get(i);
			Portal portal2 = portales.get(i+1);
			Baldoza b1 = (Baldoza) portal.getDesde();
			Baldoza b2 = (Baldoza) portal.getHasta();
			Baldoza b3 = (Baldoza) portal2.getDesde();
			Baldoza b4 = (Baldoza) portal2.getHasta();
			connect(b1,b2);
			connect(b2,b3);
			connect(b3,b4);
		}
	}
	
	private void connect(Baldoza b1, Baldoza b2) {

		
		if (b1.getPiso() == b2.getPiso() && b1.getMetros() != b2.getMetros()){
			int masChico = Math.min(b1.getMetros(), b2.getMetros());
			int masGrande = Math.max(b1.getMetros(), b2.getMetros());
			for (int i = masChico; i <= masGrande; i++) {
				if (nodos.get(b1.getPiso() + "," + i) == null){
					addNodo(b1.getPiso(), i);
				}
			}
			for (int i = masChico; i < masGrande; i++) {
				int j = i+1;
				connect(b1.getPiso()+","+i,b1.getPiso()+","+ j);
			}
			
			
		} else {
			if (nodos.get(b1.getPiso() + "," + b1.getMetros()) == null){
				addNodo(b1.getPiso(), b1.getMetros());
			}
			if (nodos.get(b2.getPiso() + "," + b2.getMetros()) == null){
				addNodo(b2.getPiso(), b2.getMetros());
			}
			addNodo(100, nodoFantasma);
			
			connect(b1.getPiso() + "," + b1.getMetros() , "100,"+ nodoFantasma);
			connect("100,"+ nodoFantasma , b2.getPiso() + "," + b2.getMetros());
			nodoFantasma++;
		}
		
	}

	private void connect(String string, String string2) {
		Nodo a = getNodo(string);
		Nodo b = getNodo(string2);
		if (! a.getVecinos().contains(b)){
			a.addVecino(b);
		}
		if (! b.getVecinos().contains(a)){
			b.addVecino(a);
		}
		
		
	}

	public void addVertice(Baldoza b1, Baldoza b2, int peso ) {
		Vertice vertice = new Vertice(b1, b2, peso);
		vertice.setId(idVertices);
		idVertices++;
		
		this.peso += peso;
	}
	public Nodo addNodo(int piso, int mts){
		nodos.put(piso+","+mts, new Nodo(idVertices));
		idVertices++;
		nodos.get(piso+","+mts).setCoordenada(piso+","+mts);
		return nodos.get(piso+","+mts);
	}
	public Nodo getNodo(String string){
		return nodos.get(string);
	}

	public int solve(String n1, String n2, int i) {
		
		solve(nodos.get(n1),nodos.get(n2),0);
		return nodos.get(n2).getLongitud();
	}

	private int solve(Nodo nodo, Nodo nodo2, int i) {
		LinkedList<Nodo> cola = new LinkedList<Nodo>();
		
		cola.addFirst(nodo);
		nodo.setVisitado();
		while(! cola.isEmpty()){
			Nodo actual;
			actual = cola.pop();
			System.out.println(actual);
			List<Nodo> vecinos = actual.getVecinos();		
			for (int k = 0; k < vecinos.size() ; k++) {
				if (!vecinos.get(k).getVisitado()){
					vecinos.get(k).setVisitado();
					vecinos.get(k).setLongitud(actual.getLongitud()+1);
					System.out.println("Agrego :" + vecinos.get(k));
					cola.push(vecinos.get(k));
				}
			}
			
			
		}
		System.out.println(nodo2.getLongitud());
		return nodo2.getLongitud();
		
	}


}
