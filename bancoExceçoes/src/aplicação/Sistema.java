
package aplicação;

import java.util.Locale;
import java.util.Scanner;

import model.entidade.Account;
import molde.exceção.DominioExceção;


public class Sistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
			
		System.out.println("Insira os dados da conta ");
		System.out.print("Numero: ");
		int number= sc.nextInt();
		
		System.out.print("Titular: ");
		sc.nextLine();
		String nome= sc.nextLine();
		
		System.out.print("Saldo inial: ");
		double balance= sc.nextDouble();
		
		System.out.print("Limite de saque: ");
		double withdrawLimit= sc.nextDouble();
		
		//instaciar 
		Account conta= new Account(number, nome, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Insira o valor para saque: ");
		double amount= sc.nextDouble();
		
		try {
			conta.withdraw(amount);
			System.out.printf("Saldo atual: %.2f %n",conta.getBalance());
		}
		catch(DominioExceção e){
			System.out.println(e.getMessage());
		}
		
		
		/*tratamento de  exceção
		 * 2 caso:  ruim	
		String erro= conta.validathWithdraw(amount);
		if(erro != null) {
			System.out.println(erro); 
		}
		else {
			conta.withdraw(amount);
			System.out.printf("Saldo atual: %.2f %n",conta.getBalance());
		}
		*/
		

		/*tratamento de  exceção
		 * 1 caso: muit ruim	
		 *Tramento considerado ruim devido a delegação:
		 *
		if(conta.getBalance() >= amount && conta.getWithdrawLimit() < amount) {
			System.out.println("Erro de retirada: o valor excede o limite de saque ");
		}
		else if(conta.getBalance() < amount && conta.getWithdrawLimit() < amount ) {
			System.out.println("Erro de retirada: o valor excede o limite de retirada ");
		}
		else if (conta.getBalance() < amount && conta.getWithdrawLimit() > amount) {
			System.out.println("Erro de saque: saldo insuficiente "); 
		}
		else {
			conta.withdraw(amount);
			System.out.printf("Saldo atual: %.2f %n",conta.getBalance());
		}
		*/
		
		
		sc.close();
		
	}

}
