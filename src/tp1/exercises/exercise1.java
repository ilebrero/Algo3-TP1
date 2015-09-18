package tp1.exercises;

public class Exercise1 {
	private static int max;
	private static int cantCiudades;
	private static int cableRestante;
	private static int ultimaCiudad;
	
	public static int exerice1(Integer[] ciudades,int longCable) {
		boolean[] ultimaCiudadSumo = new boolean[ciudades.length];
		cableRestante = longCable;
		cantCiudades  = 0;
		ultimaCiudad  = 0;
		max   = 0;
			
		int i = 1;
		while ( i < ciudades.length){
			int distanciaActual = ciudades[i] - ciudades[i-1]; 

			if (cableRestante - distanciaActual >= 0){
				// puede agregar una ciudad
				cableRestante -= distanciaActual;
				cantCiudades++;
				max = Math.max(max, cantCiudades);
				ultimaCiudadSumo[i-1] = true;
				i++;
			} else {
				while (cableRestante - distanciaActual <= 0 && ultimaCiudad < i){
					if (ultimaCiudadSumo[ultimaCiudad]) {
						int distanciaASacar = (ciudades[ultimaCiudad+1] - ciudades[ultimaCiudad]);
						cableRestante += distanciaASacar;
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
