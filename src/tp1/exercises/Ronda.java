package tp1.exercises;

import java.util.ArrayList;
import java.lang.Integer;

public class Ronda{
    int sumaDistancias;
    int amigaMasLejana;

    ArrayList<Character> ronda;
    static String[] mejoresAmigas;

    public Ronda(){}

    public Ronda(ArrayList<Character> ronda){
            this.ronda = ronda;
            calcularMaximaDistancia();
            sumaDistancias();
    }

    public void swap(int i, int j){
        Character aux;
        aux = ronda.get(i);
        ronda.set(i, ronda.get(j));
        ronda.set(j, aux);
    }

    public int obtenerPos(Character niña){
        int posicion = 0;
        while (this.ronda.get(posicion) != niña) {
            posicion++;
        }
        return posicion;
    }

    public void calcularMaximaDistancia(){
        amigaMasLejana = 0;
        for (String mejoresAmiga : mejoresAmigas) {
            int posNiña = obtenerPos(mejoresAmiga.charAt(0));
            for (int j = 2; j < mejoresAmiga.length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga = obtenerPos(mejoresAmiga.charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = minimoInt(distancia, ronda.size() - distancia);
                if(distanciaMinima > amigaMasLejana) amigaMasLejana = distanciaMinima;
            }
        }
    }

    public void sumaDistancias(){
        sumaDistancias = 0;
        for (String mejoresAmiga : mejoresAmigas) {
            int posNiña = obtenerPos(mejoresAmiga.charAt(0));
            for (int j = 2; j < mejoresAmiga.length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga = obtenerPos(mejoresAmiga.charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = minimoInt(distancia, ronda.size() - distancia);
                sumaDistancias += distanciaMinima;
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

    public static char minimo(String[] amigas){
        char min = 255;
        for (int i = 0; i < amigas.length; i++) {
            for (int j = 0; j < amigas[i].length(); j++) {
                Character actual = amigas[i].charAt(j);
                if (actual < min) {
                    min = actual; 
                }
            }
        }
        return min;
    }

    public static char maximo(String[] amigas){
        char max = 0;
        for (int i = 0; i < amigas.length; i++) {
            for (int j = 0; j < amigas[i].length(); j++) {
                Character actual = amigas[i].charAt(j);
                if (actual > max) {
                    max = actual; 
                }
            }
        }
        return max;
    }

}
