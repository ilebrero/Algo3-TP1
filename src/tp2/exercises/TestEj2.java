package tp2.exercises;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.junit.Test;

public class TestEj2 {


   @Test
   public void fileWritingRunTest() throws IOException {
      // Con este test se lee el archivo de entrada proporcioando por la catedra 
      //    y se genera la salida
      BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej2.in" ) ) );
      BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej2.test.out" ) );
      
      String line;
      while ( ( line = is.readLine() ) != null ) {
         os.append( run( line, is.readLine() ) ).append( '\n' );
      }
      os.close();
      
   }

   @Test
   public void fileTestingRunTest() throws IOException {
      // Con este test se compara un archivo de entrada con el formato de la catedra 
      //    contra otro archivo con valores esperados
      BufferedReader source  = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej2.in" ) ) );
      BufferedReader control = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej2.out" ) ) );
      
      String line;
      while ( ( line = source.readLine() ) != null ) {
         assertEquals( control.readLine(), run( line, source.readLine() ) );
      }
      
   }

   private String run( String a, String b ) {
      StringTokenizer datos = new StringTokenizer( a, " " );
      
      return String.valueOf( new Exercise2( Integer.parseInt( datos.nextToken() ), 
                                             Integer.parseInt( datos.nextToken() ), 
                                             parsePortales( b ) ).solve() );
   }

   private List<Portal<Baldoza>> parsePortales( String line ) {
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();

      StringTokenizer st = new StringTokenizer( line, ";" );
      while ( st.hasMoreTokens() ) {
         StringTokenizer portal = new StringTokenizer( st.nextToken(), " " );
         portales.add( new Portal<Baldoza>( new Baldoza( Integer.parseInt( portal.nextToken() ), 
                                                Integer.parseInt( portal.nextToken() ) ), 
                                   new Baldoza( Integer.parseInt( portal.nextToken() ), 
                                                Integer.parseInt( portal.nextToken() ) ) ) );
      }

      return portales;
   }

	@Test
	public void test0() {
		ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		portales.add( new Portal<Baldoza>( new Baldoza( 0, 10 ), new Baldoza( 10, 1 ) ) );

		assertEquals( 21, new Exercise2( 10, 10, portales ).solve() );
	}
//
   @Test
   public void test1() {
      
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
      portales.add( new Portal<Baldoza>( new Baldoza( 0, 2 ), new Baldoza( 2, 3 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 2, 4 ), new Baldoza( 3, 2 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 3, 1 ), new Baldoza( 4, 5 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 4, 3 ), new Baldoza( 5, 2 ) ) );

      assertEquals( 17, new Exercise2( 5, 5, portales ).solve() );
   }

   @Test
   public void test2() {
      
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
      portales.add( new Portal<Baldoza>( new Baldoza( 0, 2 ), new Baldoza( 2, 3 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 2, 4 ), new Baldoza( 3, 2 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 3, 1 ), new Baldoza( 4, 5 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 4, 3 ), new Baldoza( 5, 2 ) ) );

      assertEquals( 17, new Exercise2( 5, 5, portales ).solve() );
   }
   @Test
   public void test3() {
      
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
      portales.add( new Portal<Baldoza>( new Baldoza( 0, 1 ), new Baldoza( 1, 2 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 1, 2 ), new Baldoza( 3, 1 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 2, 3 ), new Baldoza( 4, 0 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 3, 4 ), new Baldoza( 2, 1 ) ) );

      assertEquals( 18, new Exercise2( 4, 4, portales ).solve() );
   }
}