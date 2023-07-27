import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, N, L;
		
		L= sc.nextInt();
		N= sc.nextInt();
		
		for (i= 1; i <= N; i++ ) {
			
			if( i% L == 0) {
				System.out.printf("%d%n", i);
			}
			else {
				System.out.printf("%d ", i);
			}
		}
		
		sc.close();

	}

}
