import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int i, N;
		double somar, media;
		double[] vetor;
		
		N= sc.nextInt();
		vetor= new double[N];
		
		somar= 0.0;
		
		for ( i= 0; i< N; i++) {
			vetor[i]= sc.nextDouble();
		}
		
		
		for ( i= 0; i< N; i++) {
			somar += vetor[i];
		}
		media= somar/N;
		System.out.printf("%.3f %n", media);
		
		for ( i= 0; i< N; i++) {
			if ( vetor[i] < media) {
				System.out.println(vetor[i]);
			}
			
		}
		
		
		sc.close();
	}

}
