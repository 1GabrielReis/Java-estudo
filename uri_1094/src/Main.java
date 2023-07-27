import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);

		char cobaia;
		int i, N, cobaiaR, cobaiaS, cobaiaC, total, valor;
		double porcentualR, porcentualS, porcentualC;
		
		N= sc.nextInt();
		
		
		cobaiaR= 0;
		cobaiaS= 0;
		cobaiaC= 0;
		
		porcentualR= 0;
		porcentualS= 0;
		porcentualC= 0;
		
		
		for ( i= 0; i < N; i++) {
			
			valor= sc.nextInt();
			cobaia= sc.next().charAt(0);
			
			if ( cobaia == 'R') {
				cobaiaR += valor;
			}
			else if ( cobaia == 'S') {
				cobaiaS += valor;
		
			}
			else {
				cobaiaC += valor;
			}
			
			
		}
		
		total= cobaiaR+ cobaiaS+ cobaiaC;
		
		porcentualR= (double) cobaiaR* 100/ total;
		porcentualS= (double)cobaiaS* 100/ total;
		porcentualC= (double) cobaiaC* 100/ total;
		
		System.out.println( "Total: "+ total+ " cobaias");
		System.out.println( "Total de coelhos: "+ cobaiaC);
		System.out.println( "Total de ratos: "+ cobaiaR);
		System.out.println( "Total de sapos: "+ cobaiaS);
		System.out.printf("Percentual de coelhos: %.2f%%%n", porcentualC);
		System.out.printf("Percentual de ratos: %.2f%%%n", porcentualR);
		System.out.printf("Percentual de sapos: %.2f%%%n", porcentualS);
		
		sc.close();
		

	}

}
