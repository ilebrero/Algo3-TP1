package tp2.exercises;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Exercise3 {
	private Grafo grafo;
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
		
		ArrayList<Vertice> vertices = new ArrayList(grafo.getVertices());
		
		
		
	}
}
