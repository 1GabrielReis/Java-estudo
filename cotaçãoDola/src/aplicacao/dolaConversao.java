package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import util.converte;


public class dolaConversao {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double cot, valor, pagamento, converçãoDireta;
		
		System.out.println("Qual a cotação no momento: ");
		cot= sc.nextDouble();
		
		System.out.println("Valor em dola: ");
		valor= sc.nextDouble();
		
		
		converçãoDireta= converte.converção(valor, cot);
		System.out.println("Converção direta R$: "+ converçãoDireta);
		
		pagamento = converte.converçãoImposto(valor,cot );
		System.out.printf("Pagamento de R$:  %.2f %n", pagamento);
		
		
		sc.close();
		
	}

}
