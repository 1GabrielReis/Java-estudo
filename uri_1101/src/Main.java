import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i,M, N, maior, menor, soma;
		
		M= sc.nextInt();
		N= sc.nextInt();
		
		
		while (M != 0 && N != 0) {
			
			if ( M > N ) {
				
				maior= M;
				menor= N;
			}
			else {
				maior= N;
				menor= M;
			}
			
			soma= 0;
			
			for ( i = menor; i <= maior; i++) {
				
				System.out.print(i+" ");
				soma += i;
			}
			
			System.out.println("Sum="+soma);
			
			M= sc.nextInt();
			N= sc.nextInt();
		}
		
		sc.close();

	}

}
