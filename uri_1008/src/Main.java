import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int numeroFuncionario, horasTrabalho;
		double salarioHoras, salarioTotal;
		
		numeroFuncionario = sc.nextInt();
		horasTrabalho = sc.nextInt();
		salarioHoras = sc.nextDouble();
		
		salarioTotal = horasTrabalho * salarioHoras;
		
		System.out.println("NUMBER = " + numeroFuncionario);
		System.out.printf("SALARY = U$ %.2f%n" , salarioTotal);
		
		sc.close();
	}

}
