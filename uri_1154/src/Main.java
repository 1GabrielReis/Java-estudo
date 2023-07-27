import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int idade, somar, quantidade;
		double media;
		
		somar= 0;
		media= 0;
		quantidade= 0;
		
		idade= sc.nextInt();
		
		while (idade >= 0) {
			
			somar += idade;
			quantidade += 1;
			
			idade= sc.nextInt();
			
		}
		
		media= (double) somar/ quantidade;
		
		System.out.printf("%.2f%n", media);
		
		sc.close();

	}

}
