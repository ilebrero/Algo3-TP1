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
	private int nodoFantasma = 0;
	private int mts;
	private Boolean[] pisosUsados;
	public Grafo2(List<Portal<Baldoza>> portales, int pisos, int mts) {
		this.mts = mts;
		pisosUsados = new Boolean[pisos + 1];
		for (int i = 0; i < pisosUsados.length; i++) {
			pisosUsados[i] = false;
		}
		nodos = new HashMap<String,Nodo>();
		idVertices = 0;
		
		for (int i = 0; i < portales.size() ; i++) {
			Portal<Baldoza> portal = portales.get(i);		
			Baldoza b1 = (Baldoza) portal.getDesde();
			Baldoza b2 = (Baldoza) portal.getHasta();
			connect(b1,b2);
		}
	}
	
	private void connect(Baldoza b1, Baldoza b2) {
		checkFloor(b1);
		checkFloor(b2);	
		if (b1.getPiso() != b2.getPiso()){
			addNodo(100, nodoFantasma);
			connect(b1.getPiso() + "," + b1.getMetros() , "100,"+ nodoFantasma);
			connect("100,"+ nodoFantasma , b2.getPiso() + "," + b2.getMetros());
			nodoFantasma++;
		}	
	}

	private void checkFloor(Baldoza b2){
		if (!pisosUsados[b2.getPiso()]){
			pisosUsados[b2.getPiso()] = true;
			for (int j = 0; j <= mts; j++) {
				addNodo(b2.getPiso(), j);
			}
			for (int j = 0; j < mts; j++) {
					int k = j + 1;
					connect(b2.getPiso()+","+j, b2.getPiso()+","+k);
			}
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
	}
	
	public Nodo addNodo(int piso, int mts){
		if (nodos.get(piso + "," + mts) == null) {
		nodos.put(piso+","+mts, new Nodo(idVertices));
		idVertices++;
		nodos.get(piso+","+mts).setCoordenada(piso+","+mts);
		}
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
			//System.out.println(actual);
			List<Nodo> vecinos = actual.getVecinos();		
			for (int k = 0; k < vecinos.size() ; k++) {
				if (!vecinos.get(k).getVisitado()){
					vecinos.get(k).setVisitado();
					vecinos.get(k).setLongitud(actual.getLongitud()+1);
					//System.out.println("Agrego :" + vecinos.get(k));
					cola.push(vecinos.get(k));
				}
			}	
		}
		//System.out.println(nodo2.getLongitud());
		return nodo2.getLongitud();	
	}
}
