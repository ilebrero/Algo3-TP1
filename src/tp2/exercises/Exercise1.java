package tp2.exercises;

import java.util.List;

public class Exercise1 {
	private static int[][] matriz;
	
	public static int main(String[] args) {
		return exercise1(4);
	}
	
	public static int exercise1(int pisos) {
		matriz = new int[pisos][pisos];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (j == i){
					matriz[i][j] = 0;
				} else {
					matriz[i][j] = -2;
				}
			}
		}
		
		matriz[0][1] = -1;
		matriz[0][3] = -1;
		matriz[1][2] = -1;
		matriz[1][3] = -1;
		matriz[2][3] = -1;
		
//		for (Portal portal : portales) {
//			matriz[portal.getFrom()][portal.getTo()] = -1;
//		}
		
		return resolver();
		
	}
	private static int resolver() {
		for (int i = 0; i < matriz.length -1; i++) {
			if (matriz[i][matriz.length-1] == -1){
				matriz[i][matriz.length-1] = 1;
			}
		}
		
		int portales;
		for (int i = matriz.length -2; i >= 0; i--) {
			portales = 2;
			for (int j = matriz.length - 2; j > i; j--) {
				if (matriz[i][j] == -1 && matriz[i+1][j+1] > 0){
					matriz[i][j] = matriz[i+1][j+1] + 1;
				}
				portales++;
			}
		}
		
		int max = 0;
		for (int i = 0; i < matriz.length; i++) {
			max = Math.max(max, matriz[0][i]);
		}
		
		
		System.out.println(matriz.toString().toString());
		return max;
		
	}

}
