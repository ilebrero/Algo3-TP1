import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //TODO: pasar a archivos y generalizar la creacion de "ronda"
        //while(in.hasNext()){
            //levantar de consola -> el caso puesto es para el test 2 de la catedra
            Ronda ronda = new Ronda({'a','b','c','d','e'});//,'f','g','h'};
            ronda.mejoresAmigas = in.nextLine().split(";");
            //busca permutaciones y prueba
            Ronda rondaFinal = resolveNacho(ronda, 0);
            //muestra resultado
            System.out.println(rondaFinal.amigaMasLejana + " " + Arrays.toString(rondaFinal.ronda));
        //}
    }
/*    
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
            Pair<Pair<Integer, Integer>, Character[]> mejorRonda = optimizarRonda(nuevaRonda, mejoresAmigas, permutacion + 1);
            //prueba la proxima permutacion
            for (int i = ronda.length - 1; i > permutacion; i--){
                swap(nuevaRonda, permutacion, i);
                Pair<Pair<Integer, Integer>, Character[]> mejorRondaPermutada = optimizarRonda(nuevaRonda, mejoresAmigas, permutacion + 1);
                swap(nuevaRonda, permutacion, i);
                
                //en orden de uso: key-value = sumaDistancias | key-key = distanciaMaxima 
                if (mejorRondaPermutada.getKey().getValue() < mejorRonda.getKey().getValue() && mejorRondaPermutada.getKey().getKey() < mejorRonda.getKey().getKey() ) {
                    mejorRonda = mejorRondaPermutada;
                }
            }   
            return mejorRonda;
        }
    }
  */  
    private static Ronda resolveNacho(Ronda test, int permutacion){
        if (test.size() == permutacion) {
            Ronda result = new Ronda(test.ronda);
            return result;
        } else {
                Ronda mejorRondaActual = resolveNacho(test, permutacion + 1);
                for(int i = permutacion + 1; i < test.ronda.size(); i++){
                    test.swap(permutacion, i);
                    Ronda mejorRondaPermutada = resolveNacho(test, permutacion + 1);
                    test.swap(permutacion, i);

                    if (mejorRondaPermutada.sumaDistancias <= mejorRondaActual.sumaDistancias && mejorRondaPermutada.amigaMasLejana < mejorRondaActual.amigaMasLejana ) {
                        mejorRondaActual = mejorRondaPermutada;
                    }
                }
            }
            return mejorRondaActual;
        }
    }
}
