import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double N1, N2, N3, N4, media, exame;
		
		N1= sc.nextDouble();
		N2= sc.nextDouble();
		N3= sc.nextDouble();
		N4= sc.nextDouble();
		
		
		
		media= ( N1* 2f+ N2* 3f+ N3* 4f+ N4* 1F)/10;
		
		System.out.println("Media: "+ media);
		
		if ( media >= 7.0) {
			System.out.println("Aluno reprovado.");
		}
		else if (media >= 5.0 && media <= 6.9) {
			
			System.out.println("Aluno em exame.");
			
			exame= sc.nextDouble();
			
			System.out.println("Nota do exame: "+ exame);
			
			media= (media+ exame)/2;
			
			if (media >= 5.0) {
				System.out.println("Aluno aprovado. ");
			}
			else {
				System.out.println("Aluno reprovado. ");
			}
			
			System.out.println("Media final: "+ media);
			
		}
		else 
			System.out.println("Aluno reprovado. ");
		
		sc.close();	

	}

}
