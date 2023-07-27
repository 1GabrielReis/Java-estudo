package aplica��o;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import java.util.Locale;
import java.util.Scanner;

import entidade.Produto;
import entidade.ProdutoImportado;
import entidade.ProdutoUsado;

public class programa {

	public static void main(String[] args) throws ParseException { // throws ParseException
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		

		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		List<Produto> lista= new ArrayList<Produto>();
		
		// programa��o
		System.out.print("Digite o n�mero de produtos: ");
		int N= sc.nextInt();
		
		for(int i= 0; i< N; i++) {
			System.out.println("Dados do produto n�" +(1+i) +": ");
			System.out.print("Produto comum, usado ou importado (c/u/i)? ");
			char ch= sc.next().charAt(0);
			
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nome= sc.nextLine();
			
			System.out.print("Pre�o: ");
			double pre�o= sc.nextDouble();
			
			if(ch == 'c') {
				Produto produto= new Produto(nome, pre�o);
				lista.add(produto);
			}
			else if(ch == 'u'){
				System.out.print("Data de fabrica��o (DD/MM/AAAA): ");
				Date fabrica�aoData= formatoData.parse(sc.next()); // n�o dar erro � necessario  throws ParseException no main

				Produto produto= new ProdutoUsado(nome,pre�o, fabrica�aoData);
				lista.add(produto);
			}
			else {
				System.out.print("taxa alfandeg�ria: ");
				double pre�oFrete= sc.nextDouble();
				
				Produto produto= new ProdutoImportado(nome, pre�o, pre�oFrete);
				lista.add(produto);
			}
			
		}
		System.out.println();
		System.out.println("ETIQUETAS DE PRE�O: ");
		for(Produto produto: lista) {
			System.out.print(produto.toString());
			System.out.println();
		}
		
		sc.close();

	}

}
