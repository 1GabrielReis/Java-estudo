import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int X, Y, minimo, maximo, soma, i;
		
		X= sc.nextInt();
		Y= sc.nextInt();
		soma= 0;
		
		if ( X > Y) {
			maximo= X;
			minimo= Y;
		}
		else {
			maximo= Y;
			minimo= X;
		}
		
		for ( i = minimo+ 1; i < maximo; i++) {
			if ( i% 2 != 0) {
				soma = soma + i;
			}
		}
		
		System.out.println(soma);
		
		sc.close();
		
		

	}

}
