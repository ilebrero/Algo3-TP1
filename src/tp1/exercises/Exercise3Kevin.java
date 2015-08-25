package tp1.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Exercise3Kevin {
	private static Map<Character, Set<Character>> amistades;
    
    public static void main(String[] args) {
    	amistades = new HashMap<Character,Set<Character> >();
    	
//        Scanner in = new Scanner(System.in);
        //TODO: pasar a archivos y generalizar la creacion de "ronda"
        //while(in.hasNext()){
            //levantar de consola -> el caso puesto es para el test 2 de la catedra
//            Character[] ronda = {'a','b','c','d','e'};//,'f','g','h'};
//            String[] mejoresAmigas = in.nextLine().split(";");
            //busca permutaciones y prueba
    	
            List<Character> ronda1 = new ArrayList<Character>();
            ronda1.add('a');
            ronda1.add('b');
            ronda1.add('c');
            ronda1.add('d');
            ronda1.add('e');
            
            Set<Character> testAmistad = new TreeSet<>();
            testAmistad.add('b');
            testAmistad.add('c');
            testAmistad.add('d');
            testAmistad.add('e');
            amistades.put('a',testAmistad);
            
            // b
            
            testAmistad = new TreeSet<>();
            testAmistad.add('a');
            testAmistad.add('c');
            testAmistad.add('d');
            testAmistad.add('e');
            amistades.put('b',testAmistad);
            
            // c
            
            testAmistad = new TreeSet<>();
            testAmistad.add('a');
            testAmistad.add('b');
            testAmistad.add('d');
            testAmistad.add('e');
            amistades.put('c',testAmistad);
            
            // d
            
            testAmistad = new TreeSet<>();
            testAmistad.add('a');
            testAmistad.add('b');
            testAmistad.add('c');
            amistades.put('d',testAmistad);
            testAmistad = new TreeSet<>();
            testAmistad.add('a');
            testAmistad.add('b');
            testAmistad.add('c');
            amistades.put('e',testAmistad);
            
            //abdce
            List<List<Character>> test =  generatePerm(ronda1);
           
            System.out.println(resolve(test));

            /// Ejercicio 2.
            
            List<Character> ronda2 = new ArrayList<Character>();
            
            ronda2.add('a');
            ronda2.add('b');
            ronda2.add('c');
            ronda2.add('d');
            ronda2.add('e');
            test =  generatePerm(ronda2);
            amistades = new HashMap<Character,Set<Character> >();
            testAmistad = new TreeSet<>();
            testAmistad.add('b');
            testAmistad.add('c');
            testAmistad.add('d');
            amistades.put('a',testAmistad);
            
            // b
            
            testAmistad = new TreeSet<>();
            testAmistad.add('a');
            testAmistad.add('e');
            amistades.put('b',testAmistad);
            
            // c
            
            testAmistad = new TreeSet<>();
            testAmistad.add('a');
            testAmistad.add('d');
            amistades.put('c',testAmistad);
            
            // d
            
            testAmistad = new TreeSet<>();
            testAmistad.add('a');
            testAmistad.add('c');
            amistades.put('d',testAmistad);
            testAmistad = new TreeSet<>();
            testAmistad.add('b');
            amistades.put('e',testAmistad);
            System.out.println(resolve(test));
            
     //       a bcd;b ae;c ad;d ac;e b
    }
    
    private static List<Character> resolve(List<List<Character>> test){
        int mejorPosiciones = Integer.MAX_VALUE;
        List<Character> resultado = null;
        int costo;
        int mayorLong = Integer.MAX_VALUE;
        int longActual;
        for (List<Character> prueba : test){
        	costo = calculatateCost(prueba);
        	longActual = calculateLong(prueba);
        	if (costo < mejorPosiciones &&  longActual <= mayorLong){
        		mejorPosiciones = costo;
        		resultado = prueba;
        		mayorLong = longActual;
        	} else if (costo == mejorPosiciones && longActual <= mayorLong){
        		if (compareString(prueba.toString(),resultado.toString())){
        			resultado = prueba;
        		}
        	} 
        }
        return resultado;
    }
    
    private static boolean compareString (String a, String b){
    	int i = 0;
    	while (a.charAt(i) == b.charAt(i) ){
    		i++;
    	}
    	return a.charAt(i) < b.charAt(i);
    }
    
    private static int calculatateCost(List<Character> list) {
    	int cost = 0;

    	for (Character exp1 : list) {
    		if (amistades.get(exp1) != null ){
	    		for (Character exp2 : amistades.get(exp1)){
	    			cost += calculateDistance(list,exp1,exp2);
	    		}
    		}
    	}
		return cost;
	}
    
    private static int calculateLong(List<Character> list) {
    	int long1 = 0;

    	for (Character exp1 : list) {
    		if (amistades.get(exp1) != null ){
	    		for (Character exp2 : amistades.get(exp1)){
	    			long1 = Math.max(long1, calculateDistance(list,exp1,exp2));
	    		}
    		}
    	}
		return long1;
	}
   
    private static int calculateDistance(List<Character> round, Character exp1, Character exp2){
		int posExp1 = round.size();
		int posExp2 = 0;
		
		for (int i = 0; i < round.size(); i++) {
			if (round.get(i).equals(exp1)){
				posExp1 = i;
			}
			if (round.get(i).equals(exp2)){
				posExp2 = i;
			}
		}
		
		return Math.min(Math.abs(posExp2-posExp1), round.size() - Math.abs(posExp2-posExp1));
	}
    
	public static List<List<Character>> generatePerm(List<Character> original) {
        if (original.size() == 0) { 
          List<List<Character>> result = new ArrayList<List<Character>>();
          result.add(new ArrayList<Character>());
          return result;
        }
        Character firstElement = original.remove(0);
        List<List<Character>> returnValue = new ArrayList<List<Character>>();
        List<List<Character>> permutations = generatePerm(original);
        for (List<Character> smallerPermutated : permutations) {
          for (int index=0; index <= smallerPermutated.size(); index++) {
            List<Character> temp = new ArrayList<Character>(smallerPermutated);
            temp.add(index, firstElement);
            returnValue.add(temp);
            
          }
        }
        return returnValue;
      }
 
}
