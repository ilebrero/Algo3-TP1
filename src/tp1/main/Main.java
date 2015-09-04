package tp1.main;

import java.util.ArrayList;

import org.junit.Test;

import tp1.exercises.Ronda;
import tp1.utils.TesterEj1;
import tp1.utils.TesterEj2;
import tp1.utils.TesterEj3;
import tp1.utils.ContenedorCaminos;
import tp1.utils.Utils;


public class Main {

    public static void main(String[] args){

   
        
        testCatedraTiempoEj1();
        System.out.println("test1 --------------");
        testCatedraTiempoEj2();
        System.out.println("test2 --------------");
        testCatedraTiempoEj3();
    }
    
    
    public static int testCatedraEj1Params(String i,int longCable){
    	i = "0 " + i;
        ContenedorCaminos inputs;
        Integer[] caminos = Utils.stringToVecInt(i);
        inputs = new ContenedorCaminos(longCable, caminos);
        return Integer.parseInt(TesterEj1.procesar(inputs));

    }
    
    public static String testCatedraEj2Params(String i){
    	return TesterEj2.procesar(Utils.stringToVecInt(i));
    }
    
    
    public static String testCatedraEj3Params(String input){

        Ronda rondaFinal = TesterEj3.procesar(input);
        String resultado = Integer.toString(rondaFinal.amigaMasLejana) + " ";

        for (int i =  0; i < rondaFinal.ronda.size(); i++) {
        	resultado = resultado + rondaFinal.ronda.get(i);
        }

        return resultado;

    }


    
    public static void testCatedraTiempoEj1(){
        ArrayList<ContenedorCaminos> inputs;
        ArrayList<String> resultados;
        ArrayList<Double> tiempos = new ArrayList<>();
        
        inputs     = Utils.leerInputs("Tp1Ej1.in", 1);
        resultados = new ArrayList<String>();
        
        for(ContenedorCaminos input : inputs) {
            double tiempo = System.nanoTime();
        	resultados.add(TesterEj1.procesar(input));
        	tiempo = System.nanoTime() - tiempo;
        	System.out.println("tiempo: " + tiempo);
        }

        Utils.guardarResultados("Tp1Ej1.out", resultados, 1);
    }
    
    
    public static void testCatedraTiempoEj2(){
        ArrayList<Integer[]> inputs;
        ArrayList<String> resultados;
        
        inputs     = Utils.leerInputs("Tp1Ej2.in", 2);
        resultados = new ArrayList<String>();

        for(Integer[] input : inputs) {
        	double tiempo = System.nanoTime();
            resultados.add(TesterEj2.procesar(input));
        	tiempo = System.nanoTime() - tiempo;
        	System.out.println("tiempo: " + tiempo);
        }

        Utils.guardarResultados("Tp1Ej2.out", resultados, 2);
    }
    
    public static void testCatedraTiempoEj3(){
        ArrayList<String> inputs;
        ArrayList<String> resultados;
        Ronda ronda;
        inputs     = Utils.leerInputs("Tp1Ej3.in", 3);
        resultados = new ArrayList<String>();

        for(String input : inputs) {
        	double tiempo = System.nanoTime();
        	ronda = TesterEj3.procesar(input);
            resultados.add(ronda.toString());
        	tiempo = System.nanoTime() - tiempo;
        	System.out.println("tiempo: " + tiempo);
        }

        Utils.guardarResultados("Tp1Ej3.out", resultados, 3);
    }
}