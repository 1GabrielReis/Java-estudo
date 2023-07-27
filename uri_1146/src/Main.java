import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, c, N;
		
		N= sc.nextInt();
		
		while ( N != 0) {
			
			for ( i= 1; i <= N; i++) {
				if ( i == N) {
					System.out.println(i);
				}
				else {
					System.out.printf("%d ",i);
				}
			}
			
			N= sc.nextInt();
			
		}
		
		sc.close();

	}

}
