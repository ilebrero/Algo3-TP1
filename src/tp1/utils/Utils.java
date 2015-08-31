package tp1.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils{
	
    public static BufferedReader obtenerReader(String file) throws FileNotFoundException, IOException{
        File fld = new File("");
        String path = fld.getAbsolutePath() + "/src/tp1/Tests/" + file;
        return new BufferedReader( new FileReader(path) );
    }

    public static BufferedWriter obtenerWritter(String file) throws FileNotFoundException, IOException{
        File fld = new File("");
        String path = fld.getAbsolutePath() +"/src/tp1/Tests/" + file;
        return new BufferedWriter( new FileWriter(path) );
    }

    public static int[] stringToVecInt(String valores){
    	String[] vectorResultado;
        
        vectorResultado = valores.split(" ");
    	int[] resultado = new int[vectorResultado.length];

    	for (int i = 0; i < vectorResultado.length; i++) {
    		resultado[i] = Integer.parseInt(vectorResultado[i]);
    	}

    	return resultado;
    }
    
    public static String vecIntToString(int[] valores){
    	String resultado = "";
        
    	for (int i = 0; i < valores.length-1; i++) {
    		resultado = resultado + String.valueOf( valores[i] ) + " ";
    	}
        resultado = resultado + String.valueOf( valores[ valores.length - 1 ] );

    	return resultado;
    }
   
    
}