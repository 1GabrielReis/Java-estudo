import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, j, N, X, Y, soma, cont;
		
		N= sc.nextInt();
		
		for (i= 0; i< N; i++) {
			
			X= sc.nextInt();
			Y= sc.nextInt();
			
			soma= 0;
			cont= 0;
			
			for( j= X; cont < Y; j++) {
				if (j % 2 != 0) {
					soma += j;
					cont += 1;
				}
			}
			
			System.out.println(soma);
		}
		
		sc.close();
	}

}
