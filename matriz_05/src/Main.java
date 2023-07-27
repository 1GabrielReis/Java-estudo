import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int i, j, M, N;
		int[][] A, B, C;
		
		M= sc.nextInt();
		N= sc.nextInt();
		
		A= new int[M][N];
		B= new int[M][N];
		C= new int[M][N];
		
		for (i= 0; i< M; i++) {
			for (j= 0; j< N; j++) {
				A[i][j]= sc.nextInt();
			}
		}
		
		for (i= 0; i< M; i++) {
			for (j= 0; j< N; j++) {
				B[i][j]= sc.nextInt();
			}
		}
		
		for (i= 0; i< M; i++) {
			for (j= 0; j< N; j++) {
				C[i][j]= A[i][j]+ B[i][j]; 
				
			}
		}
		
		for (i= 0; i< M; i++) {
			for (j= 0; j< N; j++) {
				System.out.print(C[i][j]+ " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
