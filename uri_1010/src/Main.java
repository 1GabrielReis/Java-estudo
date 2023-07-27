
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int codigo1, codigo2, peca1, peca2;
		double valor1, valor2, valorTotal;
		
		codigo1 = sc.nextInt();
		peca1   = sc.nextInt();
		valor1  = sc.nextDouble();
		codigo2 = sc.nextInt();
		peca2   = sc.nextInt();
		valor2  = sc.nextDouble();
		
		valorTotal = peca1*valor1 + peca2*valor2;
		
		System.out.printf("VALOR A PAGAR: R$ %.2f%n", valorTotal);
		
		sc.close();
		

	}

}
