package tp1.exercises;

import java.util.ArrayList;

public class Exercise3 {
    
    public static Ronda armarRonda(String line, ArrayList<Character> ronda){
            Ronda.mejoresAmigas = line.split(";");
            Ronda.completarRonda(ronda);
            Ronda rondaArmada = new Ronda(ronda);
            return rondaArmada;
    }

    public static Ronda mejorPermutacion(Ronda test, int permutacion){
        if (test.ronda.size() == permutacion) {
            Ronda result = new Ronda((ArrayList<Character>) test.ronda.clone());
            return result;
        } else {
                Ronda mejorRondaActual = mejorPermutacion(test, permutacion + 1);
            
                for(int i = permutacion + 1; i < test.ronda.size(); i++){
                    test.swap(permutacion, i);
                    Ronda mejorRondaPermutada = mejorPermutacion(test, permutacion + 1);
                    test.swap(permutacion, i);

                    if (mejorRondaPermutada.sumaDistancias < mejorRondaActual.sumaDistancias && mejorRondaPermutada.amigaMasLejana <= mejorRondaActual.amigaMasLejana ) {
                        mejorRondaActual = mejorRondaPermutada;
                    }
                
                }

            return mejorRondaActual;
        }
    }
}