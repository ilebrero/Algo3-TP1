import java.util.ArrayList;

class Ronda{
    int sumaDistancias;
    int amigaMasLejana;

    ArrayList<Character> ronda;
    static String[] mejoresAmigas;


    public Ronda(){}

    public Ronda(ArrayList<Character> ronda){
            this.ronda = ronda;
            calcularMaximaDistancia();
            sumaDistancias();
    }

    public void swap(int i, int j){
        Character aux;
        aux = ronda.get(i);
        ronda.set(i, ronda.get(j));
        ronda.set(j, aux);
    }

    public int obtenerPos(Character niña){
        int posicion = 0;
        while (this.ronda.get(posicion) != niña) {
            posicion++;
        }
        return posicion;
    }

    public void calcularMaximaDistancia(){
        amigaMasLejana = 0;
        for (String mejoresAmiga : mejoresAmigas) {
            int posNiña = obtenerPos(mejoresAmiga.charAt(0));
            for (int j = 2; j < mejoresAmiga.length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga = obtenerPos(mejoresAmiga.charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = Integer.min(distancia, ronda.size() - distancia);
                if(distanciaMinima > amigaMasLejana) amigaMasLejana = distanciaMinima;
            }
        }
    }

    public void sumaDistancias(){
        sumaDistancias = 0;
        for (String mejoresAmiga : mejoresAmigas) {
            int posNiña = obtenerPos(mejoresAmiga.charAt(0));
            for (int j = 2; j < mejoresAmiga.length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga = obtenerPos(mejoresAmiga.charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = Integer.min(distancia, ronda.size() - distancia);
                sumaDistancias += distanciaMinima;
            }
        }
    }

}
