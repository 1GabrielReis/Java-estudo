
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		double x, y, z, med;
		
		x = sc.nextDouble();
		y = sc.nextDouble();
		z = sc.nextDouble();
		
		med = (x*2+y*3+z*5) / 10;
		
		System.out.printf("MEDIA = %.1f\n", med);		
		
		sc.close();
	}

}
