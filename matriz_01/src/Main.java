import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int i, j, M, N;
		int[][] matriz;
		
		M= sc.nextInt();
		N= sc.nextInt();
		
		matriz= new int[M][N];
		
		for (i= 0; i< M; i++) {
			for (j= 0; j< N; j++) {
				matriz[i][j]= sc.nextInt();
			}
		}
		
		System.out.println("VALORES NEGATIVOS:");
		
		for (i= 0; i< M; i++) {
			for(j= 0; j< N; j++) { 
				if (matriz[i][j] < 0) {
					System.out.println(matriz[i][j]);
				}
			}
		}
		
		sc.close();
	}

}
