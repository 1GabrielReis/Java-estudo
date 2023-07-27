import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double x1, x2, y1, y2, D;
		
		x1= sc.nextDouble();
		y1= sc.nextDouble();
		x2= sc.nextDouble();
		y2= sc.nextDouble();
		
		D= Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		
		System.out.printf("%.4f%n", D);
		
		sc.close();

	}

}
