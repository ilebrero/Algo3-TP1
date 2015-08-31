package tp1.exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import tp1.utils.Utils;


public class Exercise2 {
    private static Queue<Integer> leftHeap ;
    private static Queue<Integer> rigthHeap;
    private static int middle;
	
    public static Integer[] exerice2(Integer[] array) {

            leftHeap  = new PriorityQueue<>(array.length);
            rigthHeap = new PriorityQueue<>(array.length);

            Integer[] resultArray = new Integer[array.length];
            for (int i = 0; i < resultArray.length; i++) {
                    resultArray[i] = calculateMediana(array[i],i);
            } 
            return resultArray;
   }
   private static int calculateMediana(int number, int i) {
           if (i ==  0){
                   // Maneja el primer caso.
                   middle = number;
           } else{
                   if (number < middle){
                           leftHeap.add(number);
                   } else {
                           rigthHeap.add(number);
                   }
           }

           adjustStruct();

           if ((i+1) % 2 == 0){
                   if (rigthHeap.size() > leftHeap.size()){
                           return ((rigthHeap.peek() + middle) /2);
                   } else {
                           return ((leftHeap.peek() + middle) /2);
                   }
           } else {
                   return middle;
           }

   }


    private static void adjustStruct(){
	// A lo sumo debe hacer un solo movimiento.
	if (rigthHeap.size() - leftHeap.size() > 1){
		leftHeap.add(middle);
		middle = rigthHeap.remove();
	} else if (leftHeap.size() - rigthHeap.size() > 1){
		rigthHeap.add(middle);
		middle = leftHeap.remove();
	}
    }

    public static ArrayList<Integer[]> leerInput(BufferedReader is) throws IOException{
        String line;
        ArrayList<Integer[]> inputs = new ArrayList<>();
        
        while ( ( line = is.readLine() ) != null ) {
            inputs.add( Utils.stringToVecInt(line) );
        }
        
        return inputs;
    }
 
    public static String procesar(Integer[] input){
        Integer[] procesado = exerice2(input);
        String resultado    = Utils.vecIntToString(procesado);
        
        return resultado;
    }

    public static void guardarResultado(BufferedWriter os, ArrayList<String> resultados) throws IOException{
        for (String resultado : resultados) {
            os.append(resultado + "\n");
        }
    }

}