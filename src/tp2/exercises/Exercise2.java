package tp2.exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
	private int pisoFin;
	private int baldozaFin;
	private List<List<Portal<Baldoza>>> baldozas;
	private Portal<Baldoza> inicio;
	public Exercise2(int pisoFin, int baldozaFin,List<Portal<Baldoza>> portales) {
		this.pisoFin = pisoFin;
		this.baldozaFin = baldozaFin;
		this.inicio = portales.get(0);
		
		baldozas = new ArrayList<List<Portal<Baldoza>>>();
		for (int i = 0; i < pisoFin; i++) {
			List<Portal<Baldoza>> bal = new ArrayList<Portal<Baldoza>>();
			baldozas.add(bal);
		}
		
		for (int i = 0; i < portales.size(); i++) {
			Portal<Baldoza> portal = portales.get(i);
			baldozas.get(portal.getDesde().getPiso()).add(portal);
		}
		
	}

	public int solve() {
		return DFS(this.inicio);
	}

	private int DFS(Portal<Baldoza> inicio) {
		
		return 0;
	}

}
