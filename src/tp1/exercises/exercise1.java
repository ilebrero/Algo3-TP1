package tp1.exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import tp1.utils.Utils;

public class exercise1 {
	private static int max;
	private static int cantCiudades;
	private static int cableRestante;
	private static int ultimaCiudad;
	private static boolean puedeSeguir;
	
    public static void main(String args[]){
        BufferedReader is;
        BufferedWriter os;
        
        try{
            is = Utils.obtenerReader("Tp1Ej1.in");
            os = Utils.obtenerWritter("Tp1Ej1.out");

            String line;
            while ( ( line = is.readLine() ) != null ) {
            	int longCable;
            	int[] caminos;

                longCable = Integer.parseInt(line);
                caminos   = Utils.stringToVecInt( is.readLine() );
                
            	int maximaCantCaminos = exerice1(caminos, longCable);
            	String resultado      = Integer.toString(maximaCantCaminos);
                
            	os.append( resultado + "\n");
            }
            os.close();
        } catch(IOException e){
            System.out.println("ocurrio un error en el input: " + e.getMessage());
        }
    }     
	public static int exerice1(int[] caminos,int longCable) {
		boolean[] ultimaCiudadSumo = new boolean[caminos.length];
		cableRestante = longCable;
		cantCiudades  = 0;
		ultimaCiudad  = 0;
		max   = 0;
			
		int i = 1;
		while ( i < caminos.length){
			int distanciaActual = caminos[i] - caminos[i-1]; 

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
						int distanciaASacar = (caminos[ultimaCiudad+1] - caminos[ultimaCiudad]);
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
