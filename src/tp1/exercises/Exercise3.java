package tp1.exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise3 {
    
    public static void main(String[] args) {
        try{
            BufferedReader is = Utils.obtenerReader("C:\\Users\\nacho\\Documents\\GitHub\\Algo3TP1\\src\\tp1\\Tests\\Tp1Ej3.in");
            BufferedWriter os = Utils.obtenerWritter("C:\\Users\\nacho\\Documents\\GitHub\\Algo3TP1\\src\\tp1\\Tests\\Tp1Ej3.out");
           
            String line;
            while ( ( line = is.readLine() ) != null ) {
                ArrayList<Character> ronda1 = new ArrayList<Character>();           
                
                Ronda ronda      = armarRonda(line, ronda1);
                Ronda rondaFinal = mejorPermutacion(ronda, 0);
                
                os.append(Integer.toString(rondaFinal.amigaMasLejana));
                os.append(" ");
                os.append(rondaFinal.ronda.toString());
                os.append("\n");
            }
            os.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    static Ronda armarRonda(String line, ArrayList<Character> ronda){
            Ronda.mejoresAmigas = line.split(";");
            Ronda.completarRonda(ronda);
            Ronda rondaArmada = new Ronda(ronda);
            return rondaArmada;
    }

    private static Ronda mejorPermutacion(Ronda test, int permutacion){
        if (test.ronda.size() == permutacion) {
            Ronda result = new Ronda((ArrayList<Character>) test.ronda.clone());
            return result;
        } else {
                Ronda mejorRondaActual = mejorPermutacion(test, permutacion + 1);
            
                for(int i = permutacion + 1; i < test.ronda.size(); i++){
                    test.swap(permutacion, i);
                    Ronda mejorRondaPermutada = mejorPermutacion(test, permutacion + 1);
                    test.swap(permutacion, i);

                    if (mejorRondaPermutada.sumaDistancias < mejorRondaActual.sumaDistancias && mejorRondaPermutada.amigaMasLejana <= mejorRondaActual.amigaMasLejana ) {
                        mejorRondaActual = mejorRondaPermutada;
                    }

                }

            return mejorRondaActual;
        }
    }
}