package tp1.exercises;

import tp1.utils.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import static tp1.exercises.Exercise2.exerice2;

public class Exercise3 {
    
    static Ronda armarRonda(String line, ArrayList<Character> ronda){
            Ronda.mejoresAmigas = line.split(";");
            Ronda.completarRonda(ronda);
            Ronda rondaArmada = new Ronda(ronda);
            return rondaArmada;
    }

    private static Ronda mejorPermutacion(Ronda test, int permutacion){
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
    
    public static ArrayList leerInput(BufferedReader is) throws IOException{
        String line;
        ArrayList<String> inputs = new ArrayList<String>();
        
        while ( ( line = is.readLine() ) != null ) {
            inputs.add( line );
        }
        
        return inputs;
    }
 
    public static String procesar(String input){
        ArrayList<Character> ronda1 = new ArrayList<Character>();           

        Ronda ronda      = armarRonda(input, ronda1);
        Ronda rondaFinal = mejorPermutacion(ronda, 0);        
        String resultado = Integer.toString(rondaFinal.amigaMasLejana) + " " + rondaFinal.ronda.toString();
        return resultado;
    }

    public static void guardarResultado(BufferedWriter os, ArrayList<String> resultados) throws IOException{
        for (String resultado : resultados) {
            os.append(resultado + "\n");
        }
    }
}