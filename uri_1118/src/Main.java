import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int rest;
		double nota1, nota2, media;
		
		rest= 1;
		
		while ( rest == 1) {
			
			nota1= sc.nextDouble();
			while (nota1 < 0 || nota1 > 10) {
				System.out.println("nota invalida");
				nota1= sc.nextDouble();
			}
			
			nota2= sc.nextDouble();
			while (nota2 < 0 || nota2 > 10) {
				System.out.println("nota invalida");
				nota2= sc.nextDouble();
			}
			
			media= (nota1+ nota2)/2;
			System.out.printf("media = %.2f%n", media);
			
			System.out.println("novo calculo (1-sim 2-nao)");
			rest= sc.nextInt();
			while ( rest != 1 && rest != 2) {
				System.out.println("novo calculo (1-sim 2-nao)");
				rest= sc.nextInt();
			}
		}
		
		sc.close();
	}

}
