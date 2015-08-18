package tp1.exercises;


public class exercise1 {
//	private static int[][] costos;
//	private static int[][] calculos;
	private static int max;
	private static int cantCiudades;
	private static int cableRestante;
	private static boolean puedeSeguir;
	private static int ultimaCiudad;
	
	public static int exerice1(int[] array,int longCable) {
		max = 0;
		cantCiudades = 0;
		cableRestante = longCable;
		ultimaCiudad = 0;
		boolean[] ultimaCiudadSumo = new boolean[array.length];
//		int[] array = new int[array2.length];
//		for (int i = 1; i < array2.length-1; i++) {
//			array[i] = (array2[i] - array2[i - 1]);
//			System.out.println(array[i]);
//		}		
		
		
//		if (cableRestante - (array[1] - array[0]) >= 0){
//			cableRestante -= (array[1] - array[0]);
//			cantCiudades++;
//			ultimaCiudadSumo[0] = true;
//			max = 1;
//		}
		int i = 1;
			
			while ( i < array.length){
				
				if (cableRestante - (array[i] - array[i-1]) >= 0){
					// puede agregar una ciudad
					cableRestante -= (array[i] - array[i-1]);
					cantCiudades++;
					max = Math.max(max, cantCiudades);
					ultimaCiudadSumo[i] = true;
					i++;
				} else {
					while (cableRestante - (array[i] - array[i-1]) <= 0 && ultimaCiudad < i){
						if (ultimaCiudadSumo[ultimaCiudad]){
							cableRestante += array[ultimaCiudad];
						}
						ultimaCiudad++;
						cantCiudades--;
						
					}
					i++;
				}
			}
		if (max > 0){
			// la ciudad que no se sumo.
			max++;
		}
		return max;
	}
	
	
	
	
	
	
	
	
//		costos = new int[array.length][array.length];
//		calculos = new int[array.length][array.length];
//		max = 0;
//		
//		calculateCostos(array);
//		
//		for (int i = 0; i < array.length; i++) {
//			calculos[i][i] = longCable;
//		}
//		int cantidadRecorrida;
//		for (int i = 0; i < array.length; i++) {
//			cantidadRecorrida = 0;
//			for (int j = i+1; j < array.length; j++) {
//				
//			}
//		}
		
		
//		return max;
	
//}


	}

//	private static void calculateCostos(int[] array) {
//		// TODO Auto-generated method stub
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array.length; j++) {
//				costos[i][j] = array[j] - array[i];
//			}
//		}
//	}
//}
