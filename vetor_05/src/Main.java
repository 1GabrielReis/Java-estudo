import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int i, N, somar, adcionar;
		double media;
		int[] vetor;
		
		N= sc.nextInt();
		vetor= new int[N];
		somar= 0;
		adcionar= 0;
		
		for ( i= 0; i< N; i++) {
			vetor[i]= sc.nextInt();
		}
		
		for ( i= 0; i< N; i++) {
			if ( vetor[i]%2 != 1) {
				somar += vetor[i];
				adcionar += 1;
				
			}
		}
		
		media= (double) somar/ adcionar;
		System.out.println(media);
		
		sc.close();
		
	}

}
