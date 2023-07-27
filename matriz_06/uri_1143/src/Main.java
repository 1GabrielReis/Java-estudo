import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, N, quadrado, cubo;
		
		N= sc.nextInt();
		
		for( i= 1; i <= N; i++) {
			
			quadrado= i* i;
			cubo= i* i* i;
			
			System.out.printf("%d %d %d %n", i, quadrado, cubo);
		}
		
		sc.close();
	}

}
