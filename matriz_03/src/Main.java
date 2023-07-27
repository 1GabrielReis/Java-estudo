import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int i, j, N, maior;
		int[][] matriz;
		
		N= sc.nextInt();
		matriz= new int[N][N];
		
		for (i= 0; i< N; i++) {
			for (j= 0; j< N; j++) {
				matriz[i][j]= sc.nextInt();
			}
		}
		
		for (i= 0; i< N; i++) {
			maior= matriz[i][0];
			
			for(j= 0; j< N; j++) {
				if ( maior < matriz[i][j]) {
					maior= matriz[i][j];
				}
			}
			System.out.println(maior);
		}
		
		sc.close();

	}

}
