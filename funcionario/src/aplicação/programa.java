package aplicação;

import java.util.Locale;
import java.util.Scanner;
import entidade.Funcionario;

public class programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		Funcionario funcionario;
		
		double porcentagem;

		funcionario= new Funcionario();
		
		System.out.println("Nome do funcionario: ");
		funcionario.nome= sc.nextLine();
		
		System.out.println("Salario bruto: ");
		funcionario.salario= sc.nextDouble();
		
		System.out.println("Imposto: ");
		funcionario.imposto= sc.nextDouble();
		
		System.out.println();
		System.out.println("Empregado: "+ funcionario.nome+ ", salario liquido:"+ funcionario.salarioL());
		System.out.println();
		
		System.out.println("Porcentagem de aumaneto");
		porcentagem= sc.nextDouble();
		funcionario.salarioN(porcentagem);
		
		System.out.println(funcionario.toString());
		
		sc.close();
		
	}

}
