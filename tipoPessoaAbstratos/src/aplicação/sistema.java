package aplicação;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Fisica;
import entidade.Juridica;
import entidade.Pessoa;

public class sistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		System.out.print("Digite o número de contribuintes: ");
		int N= sc.nextInt();
		
		for(int i= 1; i <= N; i++) {
		System.out.println("Dados do contribuinte nº "+i+":");
		System.out.print("Pessoa física ou jurídica (f/j): ");
		char ch= sc.next().charAt(0);
		System.out.print("Nome: ");  
		sc.nextLine(); // nextLine
		String nome= sc.nextLine(); // nextLine deve ser igual
		System.out.print("Rendimento anual: ");
		double rendaAnual= sc.nextDouble();
			if(ch == 'f') {
				System.out.print("Despesas com saúde: ");
				double gastoSaude= sc.nextDouble();
			
				Pessoa pessoa= new Fisica(rendaAnual, nome, gastoSaude);
				lista.add(pessoa);
				}
			else {
				System.out.print("Número de empregados: ");
				int numeroFuncionarios= sc.nextInt();
			
				Pessoa pessoa= new Juridica( rendaAnual, nome, numeroFuncionarios);
				lista.add(pessoa);
			
				}	
		
		}
		
		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		Double somar= 0.00;
		for(Pessoa c: lista) {
			//System.out.println("Nome: "+ c.getNome()+String.format(" Imposto R$:%.2f",c.imposto()));
			System.out.printf("Nome: %s - Imposto: %.2f %n",c.getNome(),c.imposto());
			somar+= c.imposto();
		}
		System.out.println();
		System.out.println("IMPOSTOS TOTAIS:");
		System.out.printf("R$: %.2f %n",somar);
		
		sc.close();
		
	}

}
