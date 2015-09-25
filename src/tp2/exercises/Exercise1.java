package tp2.exercises;

import java.util.List;

public class Exercise1 {
	private static int[][] matriz;
	private static int[]  mejores;
	public static int main(String[] args) {
		return exercise1(6);
	}
	
	public static int exercise1(int pisos) {
		matriz = new int[pisos][pisos];
		mejores = new int[pisos];
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
		matriz[0][4] = -1;
		matriz[0][6] = -1;
		matriz[1][2] = -1;
		matriz[1][4] = -1;
		matriz[1][5] = -1;
		matriz[2][3] = -1;
		matriz[2][4] = -1;
		matriz[2][5] = -1;
		matriz[3][4] = -1;
		matriz[4][6] = -1;
		matriz[5][6] = -1;

		
//		for (Portal portal : portales) {
//			matriz[portal.getFrom()][portal.getTo()] = -1;
//		}
		
		return resolver();
		
	}
	private static int resolver() {
		for (int i = 0; i < matriz.length -1; i++) {
			if (matriz[i][matriz.length-1] == -1){
				matriz[i][matriz.length-1] = 1;
				mejores[i] = 1;
			} else {
				mejores[i] = -2;
			}
		}
		
		for (int i = matriz.length -2; i >= 0; i--) {
			for (int j = matriz.length - 2; j > i; j--) {
				if (matriz[i][j] == -1 && mejores[j] > 0 ){
					matriz[i][j] = mejores[j] + 1;
					mejores[i] = Math.max(mejores[i], matriz[i][j]);
				}
			}
		}
		return mejores[0];	
	}
}
