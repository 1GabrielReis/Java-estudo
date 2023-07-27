import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int i, N, x1, x2;
		double divisao;
		
		N= sc.nextInt();
		
		for ( i= 0; i< N; i++) {
			
			x1= sc.nextInt();
			x2= sc.nextInt();
			
			if ( x2 !=  0) {
				
				divisao= (double) x1/ x2;
				System.out.printf("%.1f %n",divisao);
			}
			else {
				System.out.println("divisao impossivel");
			}
			
		}
		
		sc.close();

	}

}
