import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, X, Y, maior, menor, soma;
		
		X= sc.nextInt();
		Y= sc.nextInt();
		
		soma= 0;
		
		if ( X > Y) {
			maior= X;
			menor= Y;
		}
		else {
			maior= Y;
			menor= X;
		}
		
		for ( i = menor; i <=  maior; i++ ) {
			
			if ( i%13 != 0) {
				
				soma += i;
			}
		}
		
		System.out.println(soma);
		
		

	}

}
