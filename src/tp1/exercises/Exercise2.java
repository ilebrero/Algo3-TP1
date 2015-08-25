package tp1.exercises;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import tp1.utils.MinHeap;

public class Exercise2 {
	private static Queue<Integer> leftHeap ;
	private static Queue<Integer> rigthHeap;
	private static int middle;
	
	
 public static int[] exerice2(int[] array) {
	
	 leftHeap = new PriorityQueue<>(array.length);
	 rigthHeap = new PriorityQueue<>(array.length);

	 int[] resultArray = new int[array.length];
	 for (int i = 0; i < resultArray.length; i++) {
		 resultArray[i] = calculateMediana(array[i],i);
	 } 
	 return resultArray;
}
private static int calculateMediana(int number, int i) {
	if (i ==  1){
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
}