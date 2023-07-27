import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double ex, ey;
		
		ex= sc.nextDouble();
		ey= sc.nextDouble();
		
		if ( ex == 0 && ey == 0) {
			System.out.println("Origem");
		}
		else if ( ex == 0) {
			System.out.println("Eixo Y");
		}
		else if ( ey == 0 ) {
			System.out.println("EIXO X");
		}
		else if ( ex > 0.f &&  ey > 0.f ) {
			System.out.println("Q1");
		}
		else if ( ex < 0.f && ey > 0.f ) {
			System.out.println("Q2");
		}
		else if ( ex > 0.f && ey < 0.f ) {
			System.out.println("Q4");
		}
		else {
			System.out.println("Q3");
		}
		sc.close();

	}

}
