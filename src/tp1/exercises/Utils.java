package tp1.exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Utils{
	
    public static BufferedReader obtenerReader(String file) throws FileNotFoundException, IOException{
        return new BufferedReader( new InputStreamReader( new FileInputStream(file) ) ); 
    }

    public static BufferedWriter obtenerWritter(String file) throws FileNotFoundException, IOException{
        return new BufferedWriter( new FileWriter( file ) );
    }

}