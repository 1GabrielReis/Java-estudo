package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

public class Banco {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		Conta  usuario;
		
		System.out.print("Enter account number: ");
		int digitoConta= sc.nextInt();
		
		System.out.print("Enter account holder: ");
		sc.nextLine(); //� bem estranho, mais si ja uso sc antes e queira usar denovo com nextLine 
		// deve ser usado duas vezes nextLine, sendo um separado.
		String nome= sc.nextLine();
		
		System.out.print("Is there na initial deposit (y/n)? ");
		char depositoIncial= sc.next().charAt(0);
		System.out.println();
		
		if ( depositoIncial == 'y') {
			System.out.print("Enter initial deposit value: ");
			double primeiroDeposito= sc.nextDouble();
			usuario= new Conta(digitoConta, nome, depositoIncial, primeiroDeposito );
			System.out.println();
		}
		else {
			usuario= new Conta(digitoConta, nome, depositoIncial);
		}
		
		
		System.out.println("Account data:");
		System.out.println(usuario.toString());
		
		
		System.out.print("Enter a deposit value:");
		double altera��o= sc.nextDouble();
		usuario.deposito(altera��o);
		System.out.println("Updated account data: ");
		System.out.println(usuario.toString());
		System.out.println();
		
		System.out.print("Enter a withdraw value:");
		altera��o= sc.nextDouble();
		usuario.saca(altera��o);
		System.out.println("Updated account data:");
		System.out.println(usuario.toString());
		
		sc.close();
		
		
		
	
		
		
		
	}

}
