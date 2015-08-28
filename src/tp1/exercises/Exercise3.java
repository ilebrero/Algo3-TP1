import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //TODO: pasar a archivos y generalizar la creacion de "ronda"
        //while(in.hasNext()){
            //levantar de consola -> el caso puesto es para el test 2 de la catedra
            ArrayList<Character> ronda1 = new ArrayList<Character>();
                ronda1.add('a');
                ronda1.add('b');
                ronda1.add('c');
                ronda1.add('d');
                ronda1.add('e');
                ronda1.add('f');
                ronda1.add('g');
                ronda1.add('h');
            Ronda.mejoresAmigas = in.nextLine().split(";");
            Ronda ronda = new Ronda(ronda1);//,'f','g','h'};
            //busca permutaciones y prueba
            Ronda rondaFinal = resolveNacho(ronda, 0);
            //muestra resultado
            System.out.println(rondaFinal.amigaMasLejana + " " + (rondaFinal.ronda));
        //}
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
}

