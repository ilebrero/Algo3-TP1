import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise3 {
    
    public static void main(String[] args) {
        try{
            BufferedReader is = obtenerReader("../Tests/Tp1Ej1.in");
            BufferedWriter os = obtenerWritter("../Tests/Tp1Ej1.out");
           
            //TODO: pasar a archivos y generalizar la creacion de "ronda"
            String line;
            while ( ( line = is.readLine() ) != null ) {
                
                ArrayList<Character> ronda1 = new ArrayList<Character>();           
                Ronda ronda = armarRonda(line, ronda1);
                Ronda rondaFinal = resolveNacho(ronda, 0);

                os.append( rondaFinal.amigaMasLejana + " " + (rondaFinal.ronda) );
                System.out.println(rondaFinal.amigaMasLejana + " " + (rondaFinal.ronda));
            }
            os.close();
        }catch(IOException e){}
    }

    static Ronda armarRonda(String line, ArrayList<Character> ronda){
            Ronda.mejoresAmigas = line.split(";");
            char min = Ronda.minimo(Ronda.mejoresAmigas);
            char max = Ronda.maximo(Ronda.mejoresAmigas);
            
            completarRonda(min, max, ronda);
            
            return new Ronda(ronda);
    }

    static void completarRonda(char min, char max, ArrayList<Character> ronda){
        Set<Character> grupo = new TreeSet<Character>;
        for (int i = 0; i < ronda.size() ; i++) {
            if (ronda.get(i) != " ") {
               grupo.add(ronda.get(i));
            }
        }
        for (Character persona : grupo) {
            ronda.add(grupo.get(i);                
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

