import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		double N, R, A;
		
		 N = 3.14159;
		 R = sc.nextDouble();
		 
		 A = N * R * R;
		 
		 
		 
		
		 System.out.printf("A=%.4f%n", A);
		 
		 
		sc.close();
	}

}
