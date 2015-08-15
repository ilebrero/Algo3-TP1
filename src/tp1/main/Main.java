package tp1.main;

import tp1.exercises.Exercise2;

public class Main {

public static void main(String...arg)
{
	int[] array = {2,3,4,1,2};
	int[] array1 = {2,7,2,8,4,9,1,6,5};
	int[] array2 = {1,87,4};
	int[] array3 = {4,0,32,6,8,10};
	int[] result;
	int[] result1;
	int[] result2;
	int[] result3;
	
	result  = Exercise2.exerice2(array);
	result1 = Exercise2.exerice2(array1);
	result2 = Exercise2.exerice2(array2);
	result3 = Exercise2.exerice2(array3);
	
	
	for (int i = 0; i < result.length; i++) {
		System.out.print(result[i] + ",");	
	}
	System.out.println();
	for (int i = 0; i < result1.length; i++) {
		System.out.print(result1[i] + ",");	
	}
	System.out.println();
	for (int i = 0; i < result2.length; i++) {
		System.out.print(result2[i] + ",");	
	}
	System.out.println();
	for (int i = 0; i < result3.length; i++) {
		System.out.print(result3[i] + ",");	
	}
	
	
//	2 2 3 2 2
//	2 4 2 4 4 5 4 5 5
//	1 44 4
//	4 2 4 5 6 7
	
//    System.out.println("The Min Heap is ");
//    MinHeap minHeap = new MinHeap(15);
//    minHeap.insert(5);
//    minHeap.insert(3);
//    minHeap.insert(2);
//    minHeap.insert(2);
//    minHeap.insert(17);
//    minHeap.insert(10);
//    minHeap.insert(84);
//    minHeap.insert(19);
//    minHeap.insert(6);
//    minHeap.insert(22);
//    minHeap.insert(9);
//    minHeap.minHeap();
//
//    minHeap.print();
//    System.out.println("The Min val is " + minHeap.remove());
//    System.out.println("The Min val is " + minHeap.remove());
//    System.out.println("The Min val is " + minHeap.remove());
}
}