package tp1.exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import tp1.utils.Utils;
import tp1.utils.ContenedorCaminos;

public class exercise1 {
	private static int max;
	private static int cantCiudades;
	private static int cableRestante;
	private static int ultimaCiudad;
	private static boolean puedeSeguir;

	public static int exerice1(Integer[] caminos,int longCable) {
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
        
    public static ArrayList leerInput(BufferedReader is) throws IOException{
        String line;
        ArrayList<ContenedorCaminos> inputs = new ArrayList<>();

        while ( ( line = is.readLine() ) != null ) {
            int longCable = Integer.parseInt(line);
            Integer[] caminos   = Utils.stringToVecInt( is.readLine() );
            
            ContenedorCaminos camino;
            camino = new ContenedorCaminos(longCable, caminos);
                
            inputs.add( camino );
        }
        
        return inputs;
    }
 
    public static String procesar(ContenedorCaminos input){
        
        Integer procesado = exerice1(input.caminos, input.longitud);
        String resultado  = String.valueOf(procesado);
        
        return resultado;
    }

    public static void guardarResultado(BufferedWriter os, ArrayList<String> resultados) throws IOException{
        for (String resultado : resultados) {
            os.append(resultado + "\n");
        }
    }

}
