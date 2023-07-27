import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int i, N, X;
		
		N= sc.nextInt();
		
		for(i= 0; i < N; i++) {
			
			X= sc.nextInt();
			
			if ( X != 0) {
				if ( X%2 ==0) {
					System.out.print("EVEN ");
				}
				else {
					System.out.print("ODD ");
				}
				if ( X > 0) {
					System.out.println("POSITIVE");
					}
				else {
					System.out.println("NEGATIVE");
				}
			}
			else {
				System.out.println("EVEN NULL");
			}
		}
		
		sc.close();

	}

}
