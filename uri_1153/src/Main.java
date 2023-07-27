import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, N, soma;
		
		N= sc.nextInt();
		
		soma= 1;
		
		for (i= 1; i <=  N; i++) {
			soma= soma* i;
		}
		
		System.out.println(soma);
		
		sc.close();
	}

}
