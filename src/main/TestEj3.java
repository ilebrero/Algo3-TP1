package tp1.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tp1.utils.TesterEj3;
import tp1.utils.Utils;


public class TestEj3 {

	@Test
	public void testsCatedra() {
		assertEquals (tp1.main.Main.testCatedraEj3Params("a bcde;b acde;c abde;d abc;e abc"), "2 abdce");
		assertEquals (tp1.main.Main.testCatedraEj3Params("a bcd;b ae;c ad;d ac;e b"), "2 abecd");
		assertEquals (tp1.main.Main.testCatedraEj3Params("a fb;b gc;d gc;f agh;e hd"), "3 abgcdehf");
		assertEquals (tp1.main.Main.testCatedraEj3Params("x yz"), "1 xyz");
	}
	
	@Test
	public void test1Element() {
		assertEquals (tp1.main.Main.testCatedraEj3Params("a"), "0 a");
		assertEquals (tp1.main.Main.testCatedraEj3Params("2"), "0 2");
		assertNotSame(tp1.main.Main.testCatedraEj3Params("1"), "0 1");
		assertNotSame(tp1.main.Main.testCatedraEj3Params("2"), "0 4"); 
	}
	
	@Test
	public void test2Element() {
		assertEquals (tp1.main.Main.testCatedraEj3Params("a b;b a"), "1 ab");
		assertEquals (tp1.main.Main.testCatedraEj3Params("a b"), "1 ab");
	}
	
    @Test
    public void testCatedraEj3(){
        ArrayList<String> inputs;
        ArrayList<String> resultados;

        inputs     = Utils.leerInputs("Tp1Ej3.in", 3);
        resultados = new ArrayList<String>();

        for(String input : inputs) {
            resultados.add(TesterEj3.procesar(input).toString());
        }

        Utils.guardarResultados("Tp1Ej3.out", resultados, 3);
    }

	@Test
	public void worstCase() {
		String string;
		string = generateFriendships(8, 8);
		tp1.main.Main.testCatedraEj3Params(string);
	}

	@Test
	public void bestCase() {
		String string;
		string = generateFriendships(8, 1);
		tp1.main.Main.testCatedraEj3Params(string);
		
	}
	
	@Test
	public void generateAllbestCase() {
		String string;
		double tiempo ;
		double[] tiempos;
		for (int i = 1; i < 10; i++) {
			tiempos = new double[5];
			string = generateFriendships(i, 1);
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				tp1.main.Main.testCatedraEj3Params(string);
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			
			System.out.print(obtenerPromedio(tiempos) + ";");
			
		}
	}
	
	@Test
	public void generateAllworstCase() {

		String string;
		double tiempo ;
		double[] tiempos;
		for (int i = 1; i < 10; i++) {
			tiempos = new double[5];
			string = generateFriendships(i, i);
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				tp1.main.Main.testCatedraEj3Params(string);
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			
			System.out.print(obtenerPromedio(tiempos) + ";");
			
		}
	}

	public String generateFriendships(int elements, int friendships) {
		String result = "";

		for (int i = 0; i < elements; i++) {
			//Para que empiecen de la "a" sumo 97
			result = result + (char)(97 + i) + " ";
		
			for (int j = 0; j < friendships; j++) {
				result = result + (char)(97 + j);
			}
		
			result = result + ";";
		}
		
		System.out.println(result);
		
		return result;
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