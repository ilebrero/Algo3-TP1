class Ronda{
	int sumaDistancias;
	int amigaMasLejana;

	List<Character> ronda;
	Static String[] mejoresAmigas;


	public Ronda(){}

	public Ronda(List<Character> ronda){
		this.ronda = ronda;
		calcularMaximaDistancia();
		sumaDistancias();
	}

	public void swap(int i, int j){
		Character aux;
        aux      = ronda[i];
        ronda[i] = ronda[j];
        ronda[j] = aux;	
	}

	public static int obtenerPos(Character niña){
        int posicion = 0;
        while (this.ronda[posicion] != niña) {
            posicion++;
        }
        return posicion;
    }

    public static int calcularMaximaDistancia(){
        int distanciaMaxima = 0;
        
        for (int i = 0; i < mejoresAmigas.length; i++) {
            int posNiña = obtenerPos(ronda, mejoresAmigas[i].charAt(0));
        
            for (int j = 2; j < mejoresAmigas[i].length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga   = obtenerPos(ronda, mejoresAmigas[i].charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = Integer.min(distancia, ronda.length - distancia);
                if(distanciaMinima > distanciaMaxima) distanciaMaxima = distanciaMinima;
            }

        }
        this.amigaMasLejana = distanciaMaxima;
    }

    public static int sumaDistancias(){
        int sumaDistancias = 0;
        for (int i = 0; i < mejoresAmigas.length; i++) {
            int posNiña = obtenerPos(ronda, mejoresAmigas[i].charAt(0));
            for (int j = 2; j < mejoresAmigas[i].length(); j++) {
                //Calcula la menor distancia entre amigas
                int posicionAmiga   = obtenerPos(ronda, mejoresAmigas[i].charAt(j));
                int distancia       = Math.abs(posNiña - posicionAmiga);
                int distanciaMinima = Integer.min(distancia, ronda.length - distancia);
                sumaDistancias += distanciaMinima;
            }
        }
        this.sumaDistancias = sumaDistancias;
    }

}