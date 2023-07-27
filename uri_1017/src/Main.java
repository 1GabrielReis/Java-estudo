import java.util.Locale;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int T, V;
		double L;
		
		T = sc.nextInt();
		V = sc.nextInt();
		
		L = ( double ) T * V / 12;
		
		System.out.printf("%.3f%n" , L);
		
		sc.close();
		

	}

}
