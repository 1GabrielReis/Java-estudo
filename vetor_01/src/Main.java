import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int i, N, posicao;
		double vmaior;
		double[] vetor;
		
		N= sc.nextInt();
		vetor=new double[N];
		
		for (i = 0; i< N; i++) {
			
			vetor[i]=sc.nextDouble();
		}
		
		vmaior = vetor[0];
		posicao= 0;
		
		for (i = 0; i< N; i++) {
			
			if ( vetor[i]> vmaior ) {
				vmaior= vetor[i];
				posicao= i;
				
			}
		
		}
		
		System.out.printf("%.1f %n",vmaior);
		System.out.println(posicao);
		
		sc.close();
		
	
	}

}
