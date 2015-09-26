package tp1.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tp1.utils.ContenedorCaminos;
import tp1.utils.TesterEj1;
import tp1.utils.Utils;


public class TestEj1 {

	@Test
	public void test1Element() {	
		assertEquals(tp1.main.Main.testCatedraEj1Params("1",0), 0);
		assertEquals(tp1.main.Main.testCatedraEj1Params("2",3), 2);
		assertNotSame(tp1.main.Main.testCatedraEj1Params("1",0),1);
		assertNotSame(tp1.main.Main.testCatedraEj1Params("2",1),1);	 
	}
	
	@Test
	public void test2Element() {	
		assertEquals(tp1.main.Main.testCatedraEj1Params("1 2",0), 0);
		assertEquals(tp1.main.Main.testCatedraEj1Params("2",3), 2);
		assertNotSame(tp1.main.Main.testCatedraEj1Params("1",0),1);
		assertNotSame(tp1.main.Main.testCatedraEj1Params("2",1),1);	 
	}
	
	@Test
    public void testCatedraEj1(){
        ArrayList<ContenedorCaminos> inputs;
        ArrayList<String> resultados;
        
        inputs     = Utils.leerInputs("Tp1Ej1.in", 1);
        resultados = new ArrayList<String>();
        
        for(ContenedorCaminos input : inputs) {
            resultados.add(TesterEj1.procesar(input));
        }

        Utils.guardarResultados("Tp1Ej1.out", resultados, 1);
    }
	@Test
	public void worstCase() {
		for (int i = 0; i < 1000000; i++) {
			tp1.main.Main.testCatedraEj1Params("1 2 4 5 7 8 6 4 5 7 8 9 4 5 8 7 4 2 1 4 7 8 5 8 1000",200);
		}
	}
	@Test
	public void bestCase() {
		for (int i = 0; i < 1000000; i++) {
			tp1.main.Main.testCatedraEj1Params("1 2 4 5 7 8 6 4 5 7 8 9 4 5 8 7 4 2 1 4 7 8 5 8 1000",2000);
		}
	}
	
	@Test
	public void generateAllbestCase() {
		for (int i = 0; i < 1000000; i++) {
			tp1.main.Main.testCatedraEj1Params("1 2 4 5 7 8 6 4 5 7 8 9 4 5 8 7 4 2 1 4 7 8 5 8 1000",2000);
		}
		String string;
		double tiempo ;
		double[] tiempos;
		for (int i = 0; i < 1000; i++) {
			tiempos = new double[5];
			string = "1";
			for (int j = 0; j < i ; j++) {
				string = string + " 1";
			}
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				tp1.main.Main.testCatedraEj1Params(string,Integer.MAX_VALUE);
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			
			System.out.println(obtenerPromedio(tiempos));
			
		}
		System.out.println("----------------");
	}
	
	@Test
	public void generateAllworstCase() {
		for (int i = 0; i < 1000000; i++) {
			tp1.main.Main.testCatedraEj1Params("1 2 4 5 7 8 6 4 5 7 8 9 4 5 8 7 4 2 1 4 7 8 5 8 1000",2000);
		}
		String string;
		double tiempo ;
		double[] tiempos;
		for (int i = 0; i < 1000; i++) {
			tiempos = new double[5];
			string = "1";
			for (int j = 0; j < i-1 ; j++) {
				string = string + " 1";
			}
			string = string + " 2000";
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				tp1.main.Main.testCatedraEj1Params(string,i);
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			
			System.out.print(obtenerPromedio(tiempos));
			
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