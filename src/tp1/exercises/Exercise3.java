package tp1.exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Exercise3 {
    
    public static void main(String[] args) {
        System.out.println("asdasds");
        try{
            BufferedReader is = obtenerReader("C:\\Users\\nacho\\Documents\\GitHub\\Algo3TP1\\src\\tp1\\Tests\\Tp1Ej3.in");
            BufferedWriter os = obtenerWritter("C:\\Users\\nacho\\Documents\\GitHub\\Algo3TP1\\src\\tp1\\Tests\\Tp1Ej3.out");
           
            String line;
            while ( ( line = is.readLine() ) != null ) {
                
                ArrayList<Character> ronda1 = new ArrayList<Character>();           
                Ronda ronda = armarRonda(line, ronda1);
                Ronda rondaFinal = resolveNacho(ronda, 0);
                
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
            char min = Ronda.minimo(Ronda.mejoresAmigas);
            char max = Ronda.maximo(Ronda.mejoresAmigas);
            
            completarRonda(min, max, ronda);
            
            Ronda rondaArmada = new Ronda(ronda);
            return rondaArmada;
    }

    static void completarRonda(char min, char max, ArrayList<Character> ronda){
        Set<Character> grupo = new TreeSet<>();
        for (String amigas : Ronda.mejoresAmigas) {
            for (int i = 0; i < amigas.length(); i++) {
                char actual = amigas.charAt(i);
                if (actual != ' ') {
                    grupo.add(actual);
                }
            }
        }
        
        for (Character persona : grupo) {
            ronda.add(persona);
        }
    }

    private static Ronda resolveNacho(Ronda test, int permutacion){
        if (test.ronda.size() == permutacion) {
            Ronda result = new Ronda((ArrayList<Character>) test.ronda.clone());
            return result;
        } else {
                Ronda mejorRondaActual = resolveNacho(test, permutacion + 1);
            
                for(int i = permutacion + 1; i < test.ronda.size(); i++){
                    test.swap(permutacion, i);
                    Ronda mejorRondaPermutada = resolveNacho(test, permutacion + 1);
                    test.swap(permutacion, i);

                    if (mejorRondaPermutada.sumaDistancias < mejorRondaActual.sumaDistancias && mejorRondaPermutada.amigaMasLejana <= mejorRondaActual.amigaMasLejana ) {
                        mejorRondaActual = mejorRondaPermutada;
                    }

                }

            return mejorRondaActual;
        }
    }

    public static BufferedReader obtenerReader(String file) throws FileNotFoundException, IOException{
        return new BufferedReader( new InputStreamReader( new FileInputStream(file) ) ); 
    }

    public static BufferedWriter obtenerWritter(String file) throws FileNotFoundException, IOException{
        return new BufferedWriter( new FileWriter( file ) );
    }


}

