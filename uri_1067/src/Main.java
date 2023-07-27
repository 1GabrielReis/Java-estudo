import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int X, i;
		
		X= sc.nextInt();
		
		
		for( i = 1; i <= X; i= i+ 2 ) {
			System.out.println(i);
		}
		
		sc.close();

	}

}
