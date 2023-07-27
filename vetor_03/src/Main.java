import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, N;
		int[] vetorA, vetorB, vetorC;
		
		N= sc.nextInt();
		
		vetorA= new int[N];
		vetorB= new int[N];
		vetorC= new int[N];
		
		for ( i= 0; i< N; i++) {
			vetorA[i]= sc.nextInt();
		}
		for ( i= 0; i< N; i++) {
			vetorB[i]=sc.nextInt();
		}
		for ( i= 0; i< N; i++) {
			vetorC[i]= vetorA[i]+ vetorB[i];
			System.out.println(vetorC[i]+" ");
		}
		
		sc.close();
		

	}

}
