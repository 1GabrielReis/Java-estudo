import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double salario, aumento, porcentagem, salarioN;
		
		salario= sc.nextDouble();
		
		if ( salario <= 400.00) {
			porcentagem= 0.15;
		}
		else if (salario <= 800.00) {
			porcentagem= 0.12; 
		}
		else if (salario <= 1200.00) {
			porcentagem= 0.10;
		}
		else if (salario  <= 2000.00)
			porcentagem= 0.07;
		else {
			porcentagem= 0.04;
		}
		
		salarioN= salario* porcentagem+ salario;
		System.out.printf( "Novo salario: %.2f%n", salarioN);
		aumento= salario* porcentagem;
		System.out.printf( "Reajuste ganho: %.2f%n", aumento);
		porcentagem= porcentagem* 100;
		porcentagem= (int) porcentagem;
		System.out.printf( "Em percentual: %.0f %%%n", porcentagem);
		
		sc.close();
		
		
		
			

	}

}
