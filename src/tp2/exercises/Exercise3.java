package tp2.exercises;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Exercise3 {
	private Grafo grafo;
	private UnionFind union;
	
	public Exercise3(java.util.List<Pasillo> pasillos) {
		grafo = new Grafo();
		for (int i = 0; i < pasillos.size(); i++) {
			Pasillo pasillo = pasillos.get(i);
			grafo.addVertice(pasillo.getExtremo1(), pasillo.getExtremo2(), pasillo.getLongitud());
		}
		union = new UnionFind(grafo.getVertices().size() + 1);
	}
	public int solve() {
		ArrayList<Vertice> vertices = grafo.getSortedVertices();
		int i = 0;
		int peso = 0;
		while (i < vertices.size()) {
			if (union.find(vertices.get(i).getNodo1()) != union.find(vertices.get(i).getNodo2())){
				union.union(vertices.get(i).getNodo1(), vertices.get(i).getNodo2());
				peso += vertices.get(i).getPeso();
			}
			i++;
		}
		return grafo.getPeso() - peso;
	}
}
