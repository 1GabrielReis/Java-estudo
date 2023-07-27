import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double valor;
		int nota;
		
		valor= sc.nextDouble();
		
		System.out.println("NOTAS:");
		
		nota= (int) valor/ 100;
		System.out.printf("%d nota(s) de R$ 100.00%n", nota);
		valor= valor% 100.00;
		
		nota= (int) valor/ 50;
		System.out.printf("%d nota(s) de R$ 50.00%n", nota);
		valor= valor% 50.00;
		
		nota= (int) valor/ 20;
		System.out.printf("%d nota(s) de R$ 20.00%n", nota);
		valor= valor% 20.00;
		
		nota= (int) valor/ 10;
		System.out.printf("%d nota(s) de R$ 10.00%n", nota);
		valor= valor% 10.00;
		
		nota= (int) valor/ 5;
		System.out.printf("%d nota(s) de R$ 5.00%n", nota);
		valor= valor% 5.00;
		
		nota= (int) valor/ 2;
		System.out.printf("%d nota(s) de R$ 2.00%n", nota);
		valor= valor% 2.00;
		
		
		System.out.println("MOEDAS:");
		valor= valor* 100;
		
		
		nota= (int) valor/ 100;
		System.out.printf("%d moeda(s) de R$ 1.00%n", nota);
		valor= valor% 100.00;
		
		nota= (int) valor/ 50;
		System.out.printf("%d moeda(s) de R$ 0.50%n", nota);
		valor= valor% 50.00;
		
		nota= (int) valor/ 25;
		System.out.printf("%d moeda(s) de R$ 0.25%n", nota);
		valor= valor% 25.00;
		
		nota= (int) valor/ 10;
		System.out.printf("%d moeda(s) de R$ 0.10%n", nota);
		valor= valor% 10.00;
		
		nota= (int) valor/ 5;
		System.out.printf("%d moeda(s) de R$ 0.05%n", nota);
		valor=  valor% 5.00;
		
		
		nota= (int) valor/ 1;
		System.out.printf("%d moeda(s) de R$ 0.01%n", nota);
		valor= valor% 1;
		
		
		sc.close();
		
		
		
		
		
	}

}
