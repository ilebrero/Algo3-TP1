package tp1.exercises;

import java.util.Arrays;

import tp1.utils.MinHeap;

public class Exercise2 {
	private static MinHeap leftHeap ;
	private static MinHeap rigthHeap;
	private static int[] middle = new int[3];
	
	
 public static int[] exerice2(int[] array) {
	 for (int j = 0; j < middle.length; j++) {
		middle[j] = 190;
	}
	 leftHeap = new MinHeap(200);
	 rigthHeap = new MinHeap(200);
	 
	 int i = 0;
	 int[] resultArray = new int[array.length];
	 
	 while (i < array.length){
		 resultArray[i] = calculateMediana(array[i],i);
		 i++;
	 }
	return resultArray;
	
}
private static int calculateMediana(int number, int i) {
	if (i < 3){
		return calculateMedianaSpecial(number, i);
	} else{
		if (number < middle[0]){
			leftHeap.insert(number);
		} else if (number < middle[1]){
			leftHeap.insert(middle[1]);
			middle[1] = number;
		} else if (number < middle[2]){
			rigthHeap.insert(middle[2]);
			middle[2] = number;
		} else {
			rigthHeap.insert(number);
		}
	}
	adjustStruct();
	if ((i+1) % 2 == 0){
		if (rigthHeap.size() > leftHeap.size()){
			return ((middle[2] + middle[1]) /2);
		} else {
			return ((middle[0] + middle[1]) /2);
		}
	} else {
		return middle[1];
	}

}


private static void adjustStruct(){
	if (rigthHeap.size() - leftHeap.size() > 1){
		leftHeap.insert(middle[0]);
		middle[0] = middle[1];
		middle[1] = middle[2];
		middle[2] = rigthHeap.remove();
	} else if (leftHeap.size() - rigthHeap.size() > 1){
		rigthHeap.insert(middle[2]);
		middle[2] = middle[1];
		middle[1] = middle[0];
		middle[0] = leftHeap.remove();
	}
}


private static int calculateMedianaSpecial(int number, int i) {
	if (i == 0){
		middle[1] = number;
		return number;
	} else if (i == 1){
		if (middle[1] > number){
			middle[0] = number;
			return ((middle[1] + middle[0])/2);
		} else {
			middle[2] = number;
			return ((middle[1] + middle[2])/2);
		}
	} else {
		int[] order = new int[4];
		for (int j = 0; j < middle.length; j++) {
			order[j] = middle[j];
		}
		order[3] = number;
		Arrays.sort(order);
		for (int j = 0; j < middle.length; j++) {
			middle[j] = order[j];
		}
	}
	return middle[1];
}
}