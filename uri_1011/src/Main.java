import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int raio = sc.nextInt();
		
		double volume = (double) (4/3.0) * 3.14159 * Math.pow(raio, 3);
		
		System.out.println("VOLUME = "+ volume);
		
		sc.close();
		
	}

}
