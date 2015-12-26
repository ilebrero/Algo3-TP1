package tp1.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import tp1.utils.TesterEj2;
import tp1.utils.Utils;

public class TestEj2 {

	@Test
	public void test1Element() {
		assertEquals(tp1.main.Main.testCatedraEj2Params("1"),"1");
		assertEquals(tp1.main.Main.testCatedraEj2Params("4"),"4");
		assertNotSame(tp1.main.Main.testCatedraEj2Params("4"),"3");
		assertNotSame(tp1.main.Main.testCatedraEj2Params("1"),"3");
	}
	
	@Test
	public void test2Element() {
		assertEquals(tp1.main.Main.testCatedraEj2Params("1 3"),"1 2");
		assertEquals(tp1.main.Main.testCatedraEj2Params("4 5"),"4 4");
		assertNotSame(tp1.main.Main.testCatedraEj2Params("4 4"),"1 1");
		assertNotSame(tp1.main.Main.testCatedraEj2Params("1 3"),"3 4");
	}
	
	@Test
    public void testCatedraEj2(){
        ArrayList<Integer[]> inputs;
        ArrayList<String> resultados;
        
        inputs     = Utils.leerInputs("Tp1Ej2.in", 2);
        resultados = new ArrayList<String>();

        for(Integer[] input : inputs) {
            resultados.add(TesterEj2.procesar(input));
        }

        Utils.guardarResultados("Tp1Ej2.out", resultados, 2);
    }
	
	@Test
	public void stress() {
		for (int i = 0; i < 1000000; i++) {
			tp1.main.Main.testCatedraEj2Params("1 4 8 7 6 8 1 2 4 5 6 8 4 3");
		}
	}
	
	@Test
	public void bestCase() {
		String string;
		for (int i = 0; i < 1000; i += 2) {
			string = "2";
			for (int j = 0; j < i ; j++) {
				if (j % 2 == 0){
					string = string + " 1";
				} else {
					string = string + " 3";
				}
			}
			tp1.main.Main.testCatedraEj2Params(string);
		}
	}
	
	@Test
	public void worstCase() {
		String string;
		for (int i = 0; i < 1000; i += 2) {
			string = "0";
			for (int j = 0 ; j < i ; j++) {
					string = string + " " + j;
			}
			tp1.main.Main.testCatedraEj2Params(string);
		}
	}
	
	@Test
	public void generateAllBestCase() {
		for (int i = 0; i < 1000000; i++) {
			tp1.main.Main.testCatedraEj2Params("1 4 8 7 6 8 1 2 4 5 6 8 4 3");
		}

		double tiempo ;
		double[] tiempos = null;
		System.out.println("WORST CASE -----");
		String string;
		for (int i = 0; i < 1000; i += 2) {
			string = "2";
			for (int j = 0; j < i ; j++) {
				if (j % 2 == 0){
					string = string + " 1";
				} else {
					string = string + " 3";
				}
			}
			tiempos = new double[5];
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				tp1.main.Main.testCatedraEj2Params(string);
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			System.out.println(obtenerPromedio(tiempos) + ";");
		}	
		System.out.println("--------------");
	}
	
	@Test
	public void generateAllWorstCase() {
		for (int i = 0; i < 1000000; i++) {
			tp1.main.Main.testCatedraEj2Params("1 4 8 7 6 8 1 2 4 5 6 8 4 3");
		}

		double tiempo ;
		double[] tiempos = null;
		System.out.println("BEST CASE -----");
		
		String string;
		for (int i = 0; i < 1000; i += 2) {
			string = "0";
			tiempos = new double[5];
			for (int j = 0 ; j < i ; j++) {
					string = string + " " + j;
			}
			
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				tp1.main.Main.testCatedraEj2Params(string);
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			System.out.print(obtenerPromedio(tiempos) + ";");
		}	
		System.out.println("--------------");
	}


	public double obtenerPromedio(double[] tiempos){
		Arrays.sort(tiempos);
		double promedio = tiempos[0];
		for (int i = 2; i < tiempos.length -1; i++) {
			promedio += tiempos[i];
		}
		
		return (promedio/3)/1000;
	}

}
