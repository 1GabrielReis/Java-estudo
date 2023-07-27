package apliação;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Empregado;
import entidade.EmpregadoTerceirizado;


public class sistema {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		List<Empregado> lista= new ArrayList<Empregado>();
		
		System.out.print("Digite o número de produtos: ");
		int N= sc.nextInt();
		
		for(int i= 1; i<= N; i++) {
			System.out.println("Dados do produto nº "+i+": ");
			
			System.out.print("Empregado terceirizado (s/n): ");
			char ch= sc.next().charAt(0);
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome= sc.nextLine();
			
			System.out.print("Horas: ");
			int horas= sc.nextInt();
			
			System.out.print("Valor por hora: ");
			double valorHora= sc.nextDouble();
			
			if(ch == 's') {
				System.out.print("Cobrança adicional: ");
				double despeza= sc.nextDouble();
				Empregado empregado= new EmpregadoTerceirizado(nome, horas, valorHora, despeza);
				lista.add(empregado);
			}
			else {
				Empregado empregado= new Empregado(nome, horas, valorHora);
				lista.add(empregado);
			}
			 
		
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS: ");
		
		for(Empregado empregado: lista) {
			System.out.println("Nome: "+empregado.getNome()+" -  Salario: $"+String.format("%.2f",empregado.pagamento()));
		}
		
		
		sc.close();
		
	}

}
