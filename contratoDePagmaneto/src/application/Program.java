package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidade.Contract;
import entidade.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int number= sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date= LocalDate.parse(sc.next(),fmt);
		System.out.print("Valor do contrato: ");
		double totalValue= sc.nextDouble();
		
		Contract obj= new Contract(number, date, totalValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int installments= sc.nextInt();
		
		ContractService contractService= new ContractService(new PaypalService());
		contractService.processContract(obj, installments);
		
		System.out.println("Parcelas: ");
		for(Installment e: obj.getInstalments()) {
			System.out.println(e);
		}
		
		sc.close();
	}

}
