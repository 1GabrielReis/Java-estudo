import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int A, B, C, AB, resultado;
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		
		AB = (A+B+Math.abs(A-B))/2;
		resultado = (AB+C+Math.abs(AB-C))/2;
		
		System.out.println( resultado +  " eh o maior");
		
		sc.close();

	}

}
