import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, N, somar;
		int[] vetor;
		
		N= sc.nextInt();
		
		vetor= new int[N];
		
		somar=0;
		
		for( i= 0; i< N; i++) {
			
			vetor[i]= sc.nextInt();	
		}
		
		
		for ( i= 0; i< N; i++) {
			if ( vetor[i]% 2 == 0) {
				System.out.println(vetor[i]+" ");
			}
		}
		System.out.println();
		
		for ( i= 0; i < N; i++) {
			if (vetor[i]%2 != 1) {
				somar += 1;
			}
		}
		
		System.out.println(somar);
		
		
		sc.close();
		

	}

}
