import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int i, j, N, somar;
		int[][] matriz;
		
		N= sc.nextInt();
		matriz= new int[N][N];
		
		somar= 0;
		
		for (i= 0; i< N; i++) {
			for (j= 0; j< N; j++) {
				matriz[i][j]= sc.nextInt();
			}
		}
		
		for ( i= 0; i< N; i++) {
			for ( j= i+ 1; j< N; j++) {
				somar += matriz[i][j];
			}
			
		}
		
		System.out.println(somar);
		
		sc.close();

	}

}
