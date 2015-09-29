package tp2.exercises;

import java.util.List;

public class Exercise2 {
	private Grafo2 grafo;
	private int piso;
	public Exercise2(int pisos, int longitud ,List<Portal<Baldoza>> portales) {
		piso = pisos;
		Baldoza p = portales.get(0).getDesde();
		portales.add(0, new Portal<Baldoza>( new Baldoza( 0, 0),  p ));
		portales.add(new Portal<Baldoza>( portales.get(portales.size()-1).getHasta(), new Baldoza( pisos, pisos) ) );
		
		grafo = new Grafo2(portales);
		
	}

	public int solve() {
		return grafo.solve("0,0",piso +"," + piso, 0);
	}

}
