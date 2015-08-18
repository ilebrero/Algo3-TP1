package tp1.main;

import tp1.exercises.Exercise2;
import tp1.exercises.exercise1;


public class Main {

public static void main(String[] args){
	
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
	
	System.out.println("Ejercicio 2:");
	
	int[] array5 = {0,6,8,12,15};
	System.out.println("Respuesta1 :" + exercise1.exerice1(array5, 6)+" y la esperada es 3");
	int[] array6 = {0,8,14,20,40,45,54,60,67,74,89,99};
	System.out.println("Respuesta2 :" + exercise1.exerice1(array6, 35) +" y la esperada es 6");

	int[] array7 ={0,35,87,141,163,183,252,288,314,356,387};
	System.out.println("Respuesta3 :" + exercise1.exerice1(array7, 100) +" y la esperada es 4");
	int[] array8 ={0,6,8,16,19,28,32,37,45,52,60,69,78,82};
	System.out.println("Respuesta4 :" + exercise1.exerice1(array8, 90) +" y la esperada es 14");
	int[] array13 ={0,5,13,19,26,35};
	System.out.println("Respuesta5 :" + exercise1.exerice1(array13, 4) +" y la esperada es 0");
	int[] array9 ={0,5,13,19,26,35};
	System.out.println("Respuesta6 :" + exercise1.exerice1(array9, 5) +" y la esperada es 2");
	int[] array10 ={0,7,16,19,27,33};
	System.out.println("Respuesta7 :" + exercise1.exerice1(array10, 5) +" y la esperada es 2");
	int[] array11 ={0,2,5,8,14,18};
	System.out.println("Respuesta8 :" + exercise1.exerice1(array11, 8) +" y la esperada es 4");
	int[] array12 ={0,3,6,9,15,19};
	System.out.println("Respuesta9 :" + exercise1.exerice1(array12, 8) +" y la esperada es 3");
//	2 2 3 2 2
//	2 4 2 4 4 5 4 5 5
//	1 44 4
//	4 2 4 5 6 7
	
}
}