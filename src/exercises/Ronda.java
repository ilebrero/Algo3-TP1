package tp1.exercises;

import java.util.ArrayList;
import java.lang.Integer;
import java.util.Set;
import java.util.TreeSet;

public class Ronda{
    public int sumaDistancias;
    public int amigaMasLejana;

    public ArrayList<Character> ronda;
    public static String[] mejoresAmigas;

    public Ronda(){}

    public Ronda(ArrayList<Character> ronda){
            this.ronda = ronda;
            calcularDistancias();
    }

    public void swap(int i, int j){
        Character aux;
        aux = ronda.get(i);
        ronda.set(i, ronda.get(j));
        ronda.set(j, aux);
    }

    public int obtenerPos(Character ni){
        int posicion = 0;
        while (this.ronda.get(posicion) != ni) {
            posicion++;
        }
        return posicion;
    }

    public void calcularDistancias(){
        amigaMasLejana = 0;
        sumaDistancias = 0;
        for (String mejoresAmiga : mejoresAmigas) {
            int posNina = obtenerPos(mejoresAmiga.charAt(0));
            for (int j = 2; j < mejoresAmiga.length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga = obtenerPos(mejoresAmiga.charAt(j));
                int distancia       = Math.abs(posNina - posicionAmiga);
                int distanciaMinima = Math.min(distancia, ronda.size() - distancia);
                //Calcuala las dos distancias
                sumaDistancias += distanciaMinima;
                if(distanciaMinima > amigaMasLejana) amigaMasLejana = distanciaMinima;
            }
        }
    }

    public static int minimoInt(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    static void completarRonda(ArrayList<Character> ronda){
        Set<Character> grupo = new TreeSet<>();

        for (String amigas : Ronda.mejoresAmigas) {
            for (int i = 0; i < amigas.length(); i++) {
                char actual = amigas.charAt(i);
                if (actual != ' ') {
                    grupo.add(actual);
                }
            }
        }

        for (Character persona : grupo) {
            ronda.add(persona);
        }
    }
    
    public String toString() {
		String string = "";
		string += amigaMasLejana + " ";
    	
		for (int i = 0; i < ronda.size(); i++) {
			string += ronda.get(i);
		}
		return string;
    }
}