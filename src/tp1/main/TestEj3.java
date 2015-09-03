package tp1.main;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


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
	public void worstCase() {
		for (int i = 0; i < 1000000; i++) {
//			tp1.main.Main.testCatedraEj3Params("1 2 4 5 7 8 6 4 5 7 8 9 4 5 8 7 4 2 1 4 7 8 5 8 1000",200);
		}
	}

	@Test
	public void bestCase() {
		for (int i = 0; i < 1000000; i++) {
//			tp1.main.Main.testCatedraEj3Params("1 2 4 5 7 8 6 4 5 7 8 9 4 5 8 7 4 2 1 4 7 8 5 8 1000",2000);
		}
	}
	
	@Test
	public void generateAllbestCase() {
		
	}
	
	@Test
	public void generateAllworstCase() {

		String string;
		double tiempo ;
		double[] tiempos;
		for (int i = 1; i < 10; i++) {
			tiempos = new double[5];
			string = generateFriendships(i);
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				tp1.main.Main.testCatedraEj3Params(string);
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			
			System.out.print(obtenerPromedio(tiempos) + ";");
			
		}
	}

	public String generateFriendships(int elements) {
		String result = "";
		
		for (int i = 0; i < elements; i++) {
			result = result + String.valueOf(i) + " ";
		
			for (int j = 0; j < elements; j++) {
				result = result + String.valueOf(j);
			}
		
			result = result + ";";
		}
		
		return result;
	}


public double obtenerPromedio(double[] tiempos){
	Arrays.sort(tiempos);
	double promedio = 0;
	for (int i = 2; i < tiempos.length -1; i++) {
		promedio += tiempos[i];
	}
	return promedio/3;
}
}