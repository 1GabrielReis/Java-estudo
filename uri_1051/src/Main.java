import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double salario, imposto;
		
		salario= sc.nextDouble();
		
		if (salario <= 2000.00) {
			
			imposto= 0.00;
		}
		else if (salario > 2000.00 && salario <= 3000.00) {
			imposto= salario* 0.08;
		}
		else if (salario > 3000.00 && salario <= 4500.00) {
			imposto= (salario - 3000.00)* 0.18 + 1000* 0.08;
		}
		else {
			imposto= (salario - 4500)* 0.28 + 1500* 0.18+ 1000* 0.08;
		}
		
		
		if (imposto == 0.00 ) {
			System.out.println("Isento");
		}
		else {
			System.out.printf(" R$ %.2f %n", imposto);
		}
		
		sc.close();
	}
	

}
