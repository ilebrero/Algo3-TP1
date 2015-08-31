package tp1.main;

import java.util.ArrayList;
import tp1.exercises.exercise1;
import tp1.utils.ContenedorCaminos;
import tp1.utils.Utils;


public class Main {

    public static void main(String[] args){
        testCatedraEj1();
        testCatedraEj2();
        testCatedraEj3();
    }
    
    public static void testCatedraEj1(){
        ArrayList<ContenedorCaminos> inputs;
        ArrayList<String> resultados;

        inputs     = Utils.leerInputs("Tp1Ej1.in", 1);
        resultados = new ArrayList<String>();

        for(ContenedorCaminos input : inputs) {
            resultados.add(exercise1.procesar(input));
        }

        Utils.guardarResultados("Tp1Ej1.out", resultados, 1);
    }
    
    public static void testCatedraEj2(){
        ArrayList<ContenedorCaminos> inputs;
        ArrayList<String> resultados;

        inputs     = Utils.leerInputs("Tp1Ej1.in", 1);
        resultados = new ArrayList<String>();

        for(ContenedorCaminos input : inputs) {
            resultados.add(exercise1.procesar(input));
        }

        Utils.guardarResultados("Tp1Ej1.out", resultados, 1);
    }
    
    public static void testCatedraEj3(){
        ArrayList<ContenedorCaminos> inputs;
        ArrayList<String> resultados;

        inputs     = Utils.leerInputs("Tp1Ej1.in", 1);
        resultados = new ArrayList<String>();

        for(ContenedorCaminos input : inputs) {
            resultados.add(exercise1.procesar(input));
        }

        Utils.guardarResultados("Tp1Ej1.out", resultados, 1);
    }
}