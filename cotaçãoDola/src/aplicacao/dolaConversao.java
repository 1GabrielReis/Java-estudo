package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import util.converte;


public class dolaConversao {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double cot, valor, pagamento, conver��oDireta;
		
		System.out.println("Qual a cota��o no momento: ");
		cot= sc.nextDouble();
		
		System.out.println("Valor em dola: ");
		valor= sc.nextDouble();
		
		
		conver��oDireta= converte.conver��o(valor, cot);
		System.out.println("Conver��o direta R$: "+ conver��oDireta);
		
		pagamento = converte.conver��oImposto(valor,cot );
		System.out.printf("Pagamento de R$:  %.2f %n", pagamento);
		
		
		sc.close();
		
	}

}
