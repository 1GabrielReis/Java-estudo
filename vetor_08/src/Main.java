import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int i, N, adcionarM, somarH;
		double maior, menor, somarM, mediaM;
		
		double[] altura;
		char[] sexo;
		
		N= sc.nextInt();
		
		altura= new double[N];
		sexo= new char[N];
		
		
		for ( i= 0; i< N; i++) {
			
			altura[i]= sc.nextDouble();
			sexo[i]= sc.next().charAt(0);
		}
		
		maior= altura[0];
		menor= altura[0];
		for ( i= 0; i< N; i++) {
			if ( maior < altura[i]) {
				maior= altura[i];
			}
			if ( menor > altura[i]) {
				menor= altura[i];
			}
		}
		
		somarM= 0;
		adcionarM= 0;
		somarH= 0;
		for ( i= 0; i< N; i++) {
			if ( sexo[i]=='F') {
				somarM += altura[i];
				adcionarM += 1;
			}
			if ( sexo[i] == 'M') {
				somarH += 1;
			}
		}
		mediaM= (double) somarM/ adcionarM;
		
		System.out.println("Menor altura = "+ menor);
		System.out.println("Maior altura = "+ maior);
		System.out.printf("Media das alturas das mulheres = %.2f%n", mediaM);
		System.out.println("Numero de homens = "+ somarH);
		
		sc.close();

	}

}
