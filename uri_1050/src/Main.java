import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int  A;
		
		A= sc.nextInt();
		
		if ( A == 61) {
			System.out.println("Brasilia");
		}
		else if ( A == 71) {
			System.out.println("Salvador");
		}
		else if ( A == 11 ) {
			System.out.println("Sao Paulo");
		}
		else if ( A == 21 ) {
			System.out.println("Rio de Janeiro");
		}
		else if ( A == 32 ) {
			System.out.println("Juiz de Fora");
		}
		else if ( A == 19 ) {
			System.out.println("Campinas");
		}
		else if ( A == 27 ) {
			System.out.println("Vitoria");
		}
		else if ( A == 31 ) {
			System.out.println("Belo Horizonte");
		}
		else {
			System.out.println("DDD nao cadastrado");
		}
		
		sc.close();
		
	}

}
