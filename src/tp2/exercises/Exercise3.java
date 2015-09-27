package tp2.exercises;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Exercise3 {
	private Grafo grafo;
	private UnionFind union;
	public Exercise3(String nodes) {
		grafo = new Grafo();
		
		String[] conexiones = nodes.split(";");
		for (String vertice : conexiones) {
			String[] vert = vertice.split(" ");
			int n1 = Integer.parseInt(vert[0]);
			int n2 = Integer.parseInt(vert[1]);
			int peso = Integer.parseInt(vert[2]);
			grafo.addVertice(n1, n2, peso);
		}
		union = new UnionFind(grafo.getVertices().size());
		
		ArrayList<Vertice> vertices = grafo.getSortedVertices();
		for (int i = 0; i < vertices.size(); i++) {
			System.out.println(vertices.get(i));
		}
		int i = 0;
		int peso = 0;
		while (i < vertices.size()) {
			if (union.find(vertices.get(i).getNodo1()) != union.find(vertices.get(i).getNodo2())){
				union.union(vertices.get(i).getNodo1(), vertices.get(i).getNodo2());
				peso += vertices.get(i).getPeso();
			}
			i++;
		}
		System.out.println(grafo.getPeso() - peso);
		
	}
}
