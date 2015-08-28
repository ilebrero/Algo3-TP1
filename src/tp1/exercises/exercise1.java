package tp1.exercises;


public class exercise1 {
	private static int max;
	private static int cantCiudades;
	private static int cableRestante;
	private static int ultimaCiudad;
	private static boolean puedeSeguir;
	
	public static int exerice1(int[] caminos,int longCable) {
		boolean[] ultimaCiudadSumo = new boolean[caminos.length];
		cableRestante = longCable;
		cantCiudades  = 0;
		ultimaCiudad  = 0;
		max   = 0;
			
		int i = 1;
		while ( i < caminos.length){
			if (cableRestante - (caminos[i] - caminos[i-1]) >= 0){
				// puede agregar una ciudad
				cableRestante -= (caminos[i] - caminos[i-1]);
				cantCiudades++;
				max = Math.max(max, cantCiudades);
				ultimaCiudadSumo[i-1] = true;
				i++;
			} else {
				while (cableRestante - (caminos[i] - caminos[i-1]) <= 0 && ultimaCiudad < i){
					if (ultimaCiudadSumo[ultimaCiudad]){
						cableRestante += (caminos[ultimaCiudad+1] - caminos[ultimaCiudad]);
						cantCiudades--;
					}
					ultimaCiudad++;
					
				}
				if (ultimaCiudad == i){
					i++;
				}
			}
		}

		if (max > 0){
			max++;
		}
		
		return max;
	}
}
