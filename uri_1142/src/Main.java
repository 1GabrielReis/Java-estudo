import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, N, primeiro, segundo, terceiro, quarto;
		
		N= sc.nextInt();
		
		primeiro= 1;
		
		for ( i= 1; i <= N; i++) {
			
			segundo= primeiro+ 1;
			terceiro= primeiro+ 2;
			quarto= primeiro+ 3;
			
			System.out.printf(" %d %d %d %d PUM%n", primeiro, segundo, terceiro, quarto);
			
			primeiro= primeiro + 4;
		}

		sc.close();
	}

}
