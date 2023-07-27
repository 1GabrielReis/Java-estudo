package aplicação;



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
		
		// programação
		System.out.print("Digite o número de produtos: ");
		int N= sc.nextInt();
		
		for(int i= 0; i< N; i++) {
			System.out.println("Dados do produto nº" +(1+i) +": ");
			System.out.print("Produto comum, usado ou importado (c/u/i)? ");
			char ch= sc.next().charAt(0);
			
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nome= sc.nextLine();
			
			System.out.print("Preço: ");
			double preço= sc.nextDouble();
			
			if(ch == 'c') {
				Produto produto= new Produto(nome, preço);
				lista.add(produto);
			}
			else if(ch == 'u'){
				System.out.print("Data de fabricação (DD/MM/AAAA): ");
				Date fabricaçaoData= formatoData.parse(sc.next()); // não dar erro é necessario  throws ParseException no main

				Produto produto= new ProdutoUsado(nome,preço, fabricaçaoData);
				lista.add(produto);
			}
			else {
				System.out.print("taxa alfandegária: ");
				double preçoFrete= sc.nextDouble();
				
				Produto produto= new ProdutoImportado(nome, preço, preçoFrete);
				lista.add(produto);
			}
			
		}
		System.out.println();
		System.out.println("ETIQUETAS DE PREÇO: ");
		for(Produto produto: lista) {
			System.out.print(produto.toString());
			System.out.println();
		}
		
		sc.close();

	}

}
