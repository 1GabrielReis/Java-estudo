package aplicação;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Clientes;
import entidade.Item;
import entidade.Ordem;
import entidade.Produto;
import entidade.enums.Status;

public class programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");// formata a data usando a class Data
		
		
		System.out.println("Entre Com os dados do cliente");
		System.out.print("Nome: ");
		String nome= sc.nextLine();
		System.out.print("E-mail: ");
		String email= sc.nextLine();
		System.out.print("Data de nascimento (DD/MM/AAAA) ");
		Date dataNascimento= formato.parse(sc.next()); // a data vai ser formatada 
		Clientes cliente= new Clientes(nome, email, dataNascimento);// construtor cliennte
		
		System.out.println("Insira os dados do pedido:");
		System.out.print("Status");
		Status status= Status.valueOf(sc.next());// enum não precisa ser instaciado
		
		Ordem ordem= new Ordem(new Date(),status, cliente); // construtor ordem e cintrução da data dia
		
		System.out.print("Quantos itens para este pedido? ");
		int N= sc.nextInt();
		for (int i= 0; i< N; i++) {
			System.out.println("Insira os dados do item nº "+(i+1)+": "); 
			System.out.print("Nome do produto: ");
			String nomeProduto= sc.next();
			System.out.print("preço do produto ");
			double preçoProduto= sc.nextDouble();
			
			Produto produto= new Produto(nomeProduto, preçoProduto); // construtor produto
			
			System.out.print("Quantidade de produto ");
			int quantidadeProduto= sc.nextInt();
			
			Item item= new Item(quantidadeProduto,preçoProduto, produto); 
			ordem.addItem(item);
			
		}
		
		System.out.println();
		System.out.println("RESUMO DO PEDIDO:");
		System.out.println(ordem.toString());
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
