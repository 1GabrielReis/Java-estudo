
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, N;
		
		N= sc.nextInt();
		
		for (i= 1; N >= i; i++) {
			
			
			
			System.out.printf(" %d %d %d %n", i, i* i, i* i* i);
			System.out.printf(" %d %d %d %n", i, i* i+ 1, i* i* i+ 1);
			
			
		}
		
		sc.close();
	}

}
