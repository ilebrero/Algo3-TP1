package tp2.exercises;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.junit.Test;

public class TestEj3 {

   @Test
   public void fileWritingRunTest() throws IOException {
      // Con este test se lee el archivo de entrada proporcioando por la catedra 
      //    y se genera la salida
      BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej3.in" ) ) );
      BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej3.test.out" ) );
      
      String line;
      while ( ( line = is.readLine() ) != null ) {
         os.append( run( line ) ).append( '\n' );
      }
      os.close();
      
   }

   @Test
   public void fileTestingRunTest() throws IOException {
      // Con este test se compara un archivo de entrada con el formato de la catedra 
      //    contra otro archivo con valores esperados
      BufferedReader source  = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej3.in" ) ) );
      BufferedReader control = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej3.out" ) ) );
      
      String line;
      while ( ( line = source.readLine() ) != null ) {
         assertEquals( control.readLine(), run( line ) );
      }
      
   }

   private String run( String line ) {      
      return String.valueOf( new Exercise3( parsePasillos( line ) ).solve() );
   }

   private List<Pasillo> parsePasillos( String line ) {
      ArrayList<Pasillo> pasillos = new ArrayList<Pasillo>();

      StringTokenizer st = new StringTokenizer( line, ";" );
      while ( st.hasMoreTokens() ) {
         StringTokenizer pasillo = new StringTokenizer( st.nextToken(), " " );
         pasillos.add( new Pasillo( Integer.parseInt( pasillo.nextToken() ), 
                                    Integer.parseInt( pasillo.nextToken() ), 
                                    Integer.parseInt( pasillo.nextToken() ) ) );
      }

      return pasillos;
   }


   
   @Test
   public void test0() {
      ArrayList<Pasillo> pasillos = new ArrayList<Pasillo>();
      pasillos.add( new Pasillo( 1, 2, 3 ) );
      pasillos.add( new Pasillo( 2, 3, 3 ) );
      pasillos.add( new Pasillo( 3, 1, 3 ) );
      assertEquals( 3, new Exercise3( pasillos ).solve() );
   }

   @Test
   public void test1() {
      ArrayList<Pasillo> pasillos = new ArrayList<Pasillo>();
      pasillos.add( new Pasillo( 1, 2, 8 ) );
      pasillos.add( new Pasillo( 1, 5, 70 ) );
      pasillos.add( new Pasillo( 1, 4, 63 ) );
      pasillos.add( new Pasillo( 2, 3, 53 ) );
      pasillos.add( new Pasillo( 2, 5, 54 ) );
      pasillos.add( new Pasillo( 3, 4, 10 ) );
      pasillos.add( new Pasillo( 3, 5, 12 ) );
      pasillos.add( new Pasillo( 4, 5, 22 ) );

      assertEquals( 52, new Exercise3( pasillos ).solve() );
   }
   
   @Test
   public void averageCaseTest() {
	   double tiempo ;
	   double[] tiempos = null;
	   System.out.println("AVERAGE CASE -----");
	   
	  for (int i = 4; i < 100000; i++) {
		  
		tiempos = new double[5];		  
		for (int l = 0; l < 5; l++){
			ArrayList<Pasillo> pasillos = new ArrayList<Pasillo>();
			int portals = (int) ( Math.random() * 100 % i ) + 1;
			  			  
			for (int j = 0; j < portals; j++) {
				int p2 = (int) ( Math.random() * 100 % portals );
				int largo = (int) ( Math.random() * 100 % portals );
				 
				pasillos.add( new Pasillo( i, p2, largo ) );
			}
			tiempo = System.nanoTime();
			new Exercise3( pasillos ).solve();
			tiempo = System.nanoTime() - tiempo;
			tiempos[l] = tiempo;
		  }
		System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
	  }
   }
   
	public double obtenerPromedio(double[] tiempos){
		Arrays.sort(tiempos);
		double promedio = 0;
		for (int i = 2; i < tiempos.length -1; i++) {
			promedio += tiempos[i];
		}
		return (promedio/3)/1000;
	}
}