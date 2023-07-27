import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int incio, fim, duracao;
		
		incio= sc.nextInt();
		fim= sc.nextInt();
		
		if (incio < fim) {
			duracao= fim - incio;
		}
		else {
			duracao= 24-incio+fim;
		}
		
		System.out.println("O JOGO DUROU "+ duracao+ "HORA(S)");
		
		sc.close();
	}
}