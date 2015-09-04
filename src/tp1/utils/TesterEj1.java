package tp1.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TesterEj1 {
	public static ArrayList leerInput(BufferedReader is) throws IOException{
        String line;
        ArrayList<ContenedorCaminos> inputs = new ArrayList<>();

        while ( ( line = is.readLine() ) != null ) {
            int longCable = Integer.parseInt(line);
            Integer[] caminos   = Utils.stringToVecInt("0 " + is.readLine() );
            
            ContenedorCaminos camino;
            camino = new ContenedorCaminos(longCable, caminos);
                
            inputs.add( camino );
        }
        
        return inputs;
    }
 
    public static String procesar(ContenedorCaminos input){
        
        Integer procesado = tp1.exercises.Exercise1.exerice1(input.caminos, input.longitud);
        String resultado  = String.valueOf(procesado);
        
        return resultado;
    }

    public static void guardarResultado(BufferedWriter os, ArrayList<String> resultados) throws IOException{
        for (String resultado : resultados) {
            os.append(resultado + "\n");
        }
    }

}
