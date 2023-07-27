import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int i, j, N, linha, coluna;
		double somarP;
		double[] linhaV, colunaV, diagonalV;
		double[][] matriz, matrizP;
		
		N= sc.nextInt();
		linhaV= new double[N];
		colunaV= new double[N];
		diagonalV= new double[N];
		matriz= new double[N][N];
		matrizP= new double[N][N];
	
		somarP= 0;
		
		for (i= 0; i< N; i++) {
			for (j= 0; j< N; j++) {
				matriz[i][j]= sc.nextDouble();
			}
		}
		
		// somar os positivos
		for (i= 0; i< N; i++) {
			for (j= 0; j< N; j++) {
				if ( matriz[i][j] > 0) {
					somarP += matriz[i][j];
				}
			}
		}
		
		
		// linha 
		linha= sc.nextInt();
		for (j= 0; j< N; j++) {
			linhaV[j]= matriz[linha][j];
		}
		
		
		// coluna
		coluna= sc.nextInt();
		for (i= 0; i< N; i++) {
			colunaV[i]= matriz[i][coluna];
		}
		
		
		//DIAGONAL PRINCIPAL
		for (i= 0; i< N; i++) {
			diagonalV[i]= matriz[i][i];
		}
		
		
		//MATRIZ ALTERADA:
		for (i= 0; i< N; i++) {
			for (j= 0; j< N; j++) {
				if ( matriz[i][j] < 0) {
					matrizP[i][j]= Math.pow(matriz[i][j], 2);
				}
				else {
					matrizP[i][j]= matriz[i][j];
				}
			}
		}
		
		

		// Respotas ////////////////////////////////////////////////////////////////////////////
		
		
		// somar os positivos
		System.out.println("SOMA DOS POSITIVOS: "+ somarP);
		
		
		// linha
		System.out.print("LINHA ESCOLHIDA: ");
		for (j= 0; j< N; j++) {
			System.out.print(linhaV[j]+ " ");
		}
		System.out.println();
		
		
		//coluna 
		System.out.print("COLUNA ESCOLHIDA: ");
		for (i= 0; i< N; i++) {
			System.out.print(colunaV[i]+ " ");
		}
		System.out.println();
		
		
		//DIAGONAL PRINCIPAL
		System.out.print("DIAGONAL PRINCIPAL: ");
		for (i= 0; i< N; i++) {
			System.out.print(diagonalV[i]+ " ");
		}
		System.out.println();
		
		
		//MATRIZ ALTERADA:
		System.out.println("MATRIZ ALTERADA: ");
		for (i= 0; i< N; i++) {
			for (j= 0; j< N; j++) {
				System.out.print(matrizP[i][j]+ " ");
			}
			System.out.println();
		}
		
		
		
		sc.close();
	}

}
