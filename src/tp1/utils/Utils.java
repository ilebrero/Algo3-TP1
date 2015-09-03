package tp1.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Utils{
 
    public static ArrayList leerInputs(String file, int ejercicio){
        BufferedReader is;
        ArrayList result = null;
        
        try{
            is = Utils.obtenerReader(file);
            
            switch(ejercicio){
                case(1):
                    result = tp1.utils.TesterEj1.leerInput(is);
                break;
                case(2):
                    result = tp1.utils.TesterEj2.leerInput(is);
                break;
                case(3):
                    result = tp1.utils.TesterEj3.leerInput(is);
                break;
            }
            
            return result;
        } catch(IOException e){
            System.out.println("ocurrio un error en el input: " + e.getMessage());
            return null;
        }

    }
    
    public static void guardarResultados(String file, ArrayList resultados, int ejercicio){
        BufferedWriter os;
        try{
            os = Utils.obtenerWritter(file);
            
            switch(ejercicio){
                case(1):
                    tp1.utils.TesterEj1.guardarResultado(os, resultados);
                break;
                case(2):
                    tp1.utils.TesterEj2.guardarResultado(os, resultados);
                break;
                case(3):
                    tp1.utils.TesterEj3.guardarResultado(os, resultados);
                break;
            }
            
            os.close();
            
            
        }catch(IOException e){
            System.out.println("ocurrio un error en el input: " + e.getMessage());
        }
    }
    
    public static BufferedReader obtenerReader(String file) throws FileNotFoundException, IOException{
        File fld = new File("");
        String path = fld.getAbsolutePath() + "/tp1/Tests/" + file;
        return new BufferedReader( new FileReader(path) );
    }

    public static BufferedWriter obtenerWritter(String file) throws FileNotFoundException, IOException{
        File fld = new File("");
        String path = fld.getAbsolutePath() +"/tp1/Tests/" + file;
        return new BufferedWriter( new FileWriter(path) );
    }

    public static Integer[] stringToVecInt(String valores){
    	String[] vectorResultado;
        
        vectorResultado = valores.split(" ");
    	Integer[] resultado = new Integer[vectorResultado.length];

    	for (int i = 0; i < vectorResultado.length; i++) {
    		resultado[i] = Integer.parseInt(vectorResultado[i]);
    	}

    	return resultado;
    }
    
    public static String vecIntToString(Integer[] valores){
    	String resultado = "";
        
    	for (int i = 0; i < valores.length-1; i++) {
    		resultado = resultado + String.valueOf( valores[i] ) + " ";
    	}
        resultado = resultado + String.valueOf( valores[ valores.length - 1 ] );

    	return resultado;
    }
   
    
}