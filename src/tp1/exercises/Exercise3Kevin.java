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
            List<Character> test4 = new ArrayList<Character>();
            test4.add('a');
            test4.add('b');
            test4.add('d');
            test4.add('c');
            test4.add('e');
            List<List<Character>> test = generatePerm(ronda1);
            test.add(test4);
            
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
            		System.out.println("entre con menor aca con : " + prueba + "con costo:" + costo + "con long:" + longActual);
            	} else if (costo == mejorPosiciones && longActual <= mayorLong){
            		if (prueba.get(0) == 'a'){
            		System.out.println("entre aca con : " + prueba + "con costo:" + costo + "con long:" + longActual);
            		}
            		if (compareString(prueba.toString(),resultado.toString())){
//            			System.out.println("Dio menor que : "+resultado  + prueba + "con costo:" + costo + "con long:" + longActual);
            			resultado = prueba;
            		}
            	} else {
            		if (prueba.get(0) == 'a'){
            		System.out.println("entre aca con mayor : " + prueba + "con costo:" + costo + "con long:" + longActual);
            		}
            	}
            }
            System.out.println(resultado);
            System.out.println(calculatateCost(test.get(test.size()-1)));
//            System.out.println(test.toString());
            System.out.println(test.size());
            //muestra resultado
//            System.out.println(rondaFinal.getKey().getKey() + " " + Arrays.toString(rondaFinal.getValue()));
        //}[a, c, d, e, b]  abdce
    }
    
    private static boolean compareString (String a, String b){
    	int i = 0;
    	while (a.charAt(i) == b.charAt(i)){
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
			if (round.get(i) == exp1){
				posExp1 = i;
			}
			if (round.get(i) == exp2){
				posExp1 = i;
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
    
//    public static Pair<Pair<Integer, Integer>, Character[]> optimizarRonda(Character[] ronda, String[] mejoresAmigas, int permutacion){
//        //caso base: hay una permutacion de la ronda
//        if (permutacion == ronda.length) {
//            Pair<Pair<Integer, Integer>, Character[]> rondaCompleta;
//            Pair<Integer, Integer> calculos = new Pair<Integer, Integer>(calcularMaximaDistancia(ronda, mejoresAmigas), sumaDistancias(ronda, mejoresAmigas));
//            rondaCompleta = new Pair<>(calculos, ronda);
//            System.out.println(Arrays.toString(ronda) + " - maximo - " + rondaCompleta.getKey().getKey() + " - suma - " + rondaCompleta.getKey().getValue());
//            return rondaCompleta;
//        //caso general: hay una permutacion a medio crear
//        } else {
//            //usa la primera rama de la recursion para generar la permutacion de menor orden lexicografico
//            Character[] nuevaRonda = ronda.clone();
//            swap(nuevaRonda, permutacion, permutacion);
//            Pair<Pair<Integer, Integer>, Character[]> mejorRonda = optimizarRonda(nuevaRonda, mejoresAmigas, permutacion + 1);
//            //prueba la proxima permutacion
//            for (int i = ronda.length - 1; i > permutacion; i--){
//                nuevaRonda = ronda.clone();
//                swap(nuevaRonda, permutacion, i);
//                Pair<Pair<Integer, Integer>, Character[]> mejorRondaPermutada = optimizarRonda(nuevaRonda, mejoresAmigas, permutacion + 1);
//                
//                //en orden de uso: key-value = sumaDistancias | key-key = distanciaMaxima 
//                if (mejorRondaPermutada.getKey().getValue() < mejorRonda.getKey().getValue() && mejorRondaPermutada.getKey().getKey() < mejorRonda.getKey().getKey() ) {
//                    mejorRonda = mejorRondaPermutada;
//                }
//            }   
//            return mejorRonda;
//        }
//    }
//    
    public static int sumaDistancias(Character[] ronda, String[] mejoresAmigas){
        int sumaDistancias = 0;
        for (int i = 0; i < mejoresAmigas.length; i++) {
            int posNiña = obtenerPos(ronda, mejoresAmigas[i].charAt(0));
            for (int j = 2; j < mejoresAmigas[i].length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga   = obtenerPos(ronda, mejoresAmigas[i].charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = Integer.min(distancia, ronda.length - distancia);
                sumaDistancias += distanciaMinima;
            }
        }
        return sumaDistancias;
    }
    
    //TODO: revizar por la complejidad!!
    public static int calcularMaximaDistancia(Character[] ronda, String[] mejoresAmigas){
        int distanciaMaxima = 0;
        
        for (int i = 0; i < mejoresAmigas.length; i++) {
            int posNiña = obtenerPos(ronda, mejoresAmigas[i].charAt(0));
        
            for (int j = 2; j < mejoresAmigas[i].length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga   = obtenerPos(ronda, mejoresAmigas[i].charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = Integer.min(distancia, ronda.length - distancia);
                if(distanciaMinima > distanciaMaxima) distanciaMaxima = distanciaMinima;
            }

        }
        
        return distanciaMaxima;
    }
    
    public static void swap(Character[] ronda, int i, int j){
        Character aux;
        aux      = ronda[i];
        ronda[i] = ronda[j];
        ronda[j] = aux;
    }
    
    public static int obtenerPos(Character[] ronda, Character niña){
        int posicion = 0;
        while (ronda[posicion] != niña) {
            posicion++;
        }
        return posicion;
    }
}
