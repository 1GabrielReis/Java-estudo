import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int i, j, N;
		int[] vetor;
		int[][] matriz;
		
		N= sc.nextInt();
		vetor= new int[N];
		matriz= new int[N][N];
		
		for (i= 0; i< N; i++) {
			for(j= 0; j< N; j++) {
				matriz[i][j]= sc.nextInt();
			}
		}
		
		for (i= 0; i< N; i++) {
			for(j= 0; j< N; j++) {
				vetor[i]= vetor[i]+ matriz[i][j];
			}
		}
		
		for (i= 0; i< N; i++) {
			System.out.println(vetor[i]);
		}
		
		sc.close();

	}

}
