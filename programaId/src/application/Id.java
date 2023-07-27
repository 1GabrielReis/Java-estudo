package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

public class Id {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		List<Conta> list= new ArrayList<Conta>(); 
		
		int i, N;
		
		System.out.print("How many employees will be registered?");
		N= sc.nextInt();
		System.out.println();
		
		for(i= 0; i< N; i++) {
			System.out.println("Emplyoee #"+(i+1)+": ");
			
			System.out.print("Id: ");
			Integer id= sc.nextInt();
			
			System.out.print("Name: ");
			sc.nextLine();
			String nome= sc.nextLine();
			
			System.out.print("Salary: ");
			Double salario= sc.nextDouble();
			
			// instansia a apgina seccudaria 
			Conta conta= new Conta(id, nome, salario);
			
			// instasia a lista
			list.add(conta);
		}
		
		System.out.print("Enter the employee id that will have salary increase : ");
		int idsalario= sc.nextInt();
		Integer posicao= posição(list, idsalario);
		if (posicao == -1) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.println("Enter the percentage: ");
			int porcentagem= sc.nextInt();
			list.get(posicao).novoSalario(porcentagem);
			// list.get(posicao)= acesssa(get) da lista (list) na posiçãoi(posicao)
		}
		
		System.out.println();
		System.out.println("List of employees: ");
		System.out.println();
		
		for(Conta conta: list) {
			System.out.println(conta.toString());
		}
		
	}

	// dizer qual a posição do id na lista 
	public static Integer posição(List<Conta> lista, int id) {
		for (int i= 0; i< lista.size(); i++) {
			if (lista.get(i).getId()==id) {
				/*
				 * encontre a posição da lista [lista.get(i).] que tenha esse id [getId()]
				 * get: parece que serve para encontra elemento (id)
				 * 
				 */
				return i;
			}
		}
		return -1; 
	}
}
