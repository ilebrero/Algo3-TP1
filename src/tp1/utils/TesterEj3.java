package tp1.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import tp1.exercises.Ronda;
import tp1.exercises.Exercise3;

public class TesterEj3 {
	 
    public static ArrayList<String> leerInput(BufferedReader is) throws IOException{
        String line;
        ArrayList<String> inputs = new ArrayList<String>();
        
        while ( ( line = is.readLine() ) != null ) {
            inputs.add( line );
        }
        
        return inputs;
    }
 
    public static Ronda procesar(String input){
        ArrayList<Character> ronda1 = new ArrayList<Character>();           

        Ronda ronda      = Exercise3.armarRonda(input, ronda1);
        Ronda rondaFinal = Exercise3.mejorPermutacion(ronda, 0);        
        return rondaFinal;
    }

    public static void guardarResultado(BufferedWriter os, ArrayList<String> resultados) throws IOException{
        for (String resultado : resultados) {
            os.append(resultado + "\n");
        }
    }
}
