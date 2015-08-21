import java.util.Arrays;
import java.util.Scanner;
import javafx.util.Pair;

public class Exercise3 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //TODO: pasar a archivos y generalizar la creacion de "ronda"
        //while(in.hasNext()){
            //levantar de consola -> el caso puesto es para el test 2 de la catedra
            Character[] ronda = {'a','b','c','d','e'};//,'f','g','h'};
            String[] mejoresAmigas = in.nextLine().split(";");
            //busca permutaciones y prueba
            Pair<Pair<Integer, Integer>, Character[]> rondaFinal = optimizarRonda(ronda, mejoresAmigas, 0);
            //muestra resultado
            System.out.println(rondaFinal.getKey().getKey() + " " + Arrays.toString(rondaFinal.getValue()));
        //}
    }
    
    public static Pair<Pair<Integer, Integer>, Character[]> optimizarRonda(Character[] ronda, String[] mejoresAmigas, int permutacion){
        //caso base: hay una permutacion de la ronda
        if (permutacion == ronda.length) {
            Pair<Pair<Integer, Integer>, Character[]> rondaCompleta;
            Pair<Integer, Integer> calculos = new Pair<Integer, Integer>(calcularMaximaDistancia(ronda, mejoresAmigas), sumaDistancias(ronda, mejoresAmigas));
            rondaCompleta = new Pair<>(calculos, ronda);
            System.out.println(Arrays.toString(ronda) + " - maximo - " + rondaCompleta.getKey().getKey() + " - suma - " + rondaCompleta.getKey().getValue());
            return rondaCompleta;
        //caso general: hay una permutacion a medio crear
        } else {
            //usa la primera rama de la recursion para generar la permutacion de menor orden lexicografico
            Character[] nuevaRonda = ronda.clone();
            swap(nuevaRonda, permutacion, permutacion);
            Pair<Pair<Integer, Integer>, Character[]> mejorRonda = optimizarRonda(nuevaRonda, mejoresAmigas, permutacion + 1);
            //prueba la proxima permutacion
            for (int i = ronda.length - 1; i > permutacion; i--){
                nuevaRonda = ronda.clone();
                swap(nuevaRonda, permutacion, i);
                Pair<Pair<Integer, Integer>, Character[]> mejorRondaPermutada = optimizarRonda(nuevaRonda, mejoresAmigas, permutacion + 1);
                
                //en orden de uso: key-value = sumaDistancias | key-key = distanciaMaxima 
                if (mejorRondaPermutada.getKey().getValue() < mejorRonda.getKey().getValue() && mejorRondaPermutada.getKey().getKey() < mejorRonda.getKey().getKey() ) {
                    mejorRonda = mejorRondaPermutada;
                }
            }   
            return mejorRonda;
        }
    }
    
    public static int sumaDistancias(Character[] ronda, String[] mejoresAmigas){
        int sumaDistancias = 0;
        for (int i = 0; i < mejoresAmigas.length; i++) {
            int posNiña = obtenerPos(ronda, mejoresAmigas[i].charAt(0));
            for (int j = 2; j < mejoresAmigas[i].length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga   = obtenerPos(ronda, mejoresAmigas[i].charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = Integer.min(distancia, ronda.length - distancia);
                sumaDistancias += distanciaMinima;
            }
        }
        return sumaDistancias;
    }
    
    //TODO: revizar por la complejidad!!
    public static int calcularMaximaDistancia(Character[] ronda, String[] mejoresAmigas){
        int distanciaMaxima = 0;
        
        for (int i = 0; i < mejoresAmigas.length; i++) {
            int posNiña = obtenerPos(ronda, mejoresAmigas[i].charAt(0));
        
            for (int j = 2; j < mejoresAmigas[i].length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga   = obtenerPos(ronda, mejoresAmigas[i].charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = Integer.min(distancia, ronda.length - distancia);
                if(distanciaMinima > distanciaMaxima) distanciaMaxima = distanciaMinima;
            }

        }
        
        return distanciaMaxima;
    }
    
    public static void swap(Character[] ronda, int i, int j){
        Character aux;
        aux      = ronda[i];
        ronda[i] = ronda[j];
        ronda[j] = aux;
    }
    
    public static int obtenerPos(Character[] ronda, Character niña){
        int posicion = 0;
        while (ronda[posicion] != niña) {
            posicion++;
        }
        return posicion;
    }
}
