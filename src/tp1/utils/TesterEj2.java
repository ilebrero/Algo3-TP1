package tp1.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TesterEj2 {

    public static ArrayList<Integer[]> leerInput(BufferedReader is) throws IOException{
        String line;
        ArrayList<Integer[]> inputs = new ArrayList<>();
        
        while ( ( line = is.readLine() ) != null ) {
            inputs.add( Utils.stringToVecInt(line) );
        }
        
        return inputs;
    }
 
    public static String procesar(Integer[] input){
        Integer[] procesado = tp1.exercises.Exercise2.exerice2(input);
        String resultado    = Utils.vecIntToString(procesado);
        
        return resultado;
    }

    public static void guardarResultado(BufferedWriter os, ArrayList<String> resultados) throws IOException{
        for (String resultado : resultados) {
            os.append(resultado + "\n");
        }
    }

}
