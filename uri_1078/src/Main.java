import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);

		int N, i, mult;
		
		N= sc.nextInt();
		
		for ( i= 1; i <= 10; i++) {
			
			mult= i* N;
			System.out.println(i+ " x "+ N+ " = "+ mult);
			
		}
		
		sc.close();
		
	}

}
