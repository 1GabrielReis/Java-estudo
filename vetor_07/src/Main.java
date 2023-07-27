import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int i, N;
		double media;
		
		String[] nome;
		double[] nota1, nota2;
		
		N= sc.nextInt();
		
		nome= new String[N];
		nota1= new double[N];
		nota2= new double[N];
		
		
		for ( i= 0; i< N; i++) {
			nome[i]= sc.next();
			nota1[i]= sc.nextDouble();
			nota2[i]= sc.nextDouble();
		}
		
		System.out.println("Alunos aprovados:");
		
		for ( i= 0; i< N; i++) {
			media= (nota1[i]+ nota2[i]);
			if ( media >= 6) {
				System.out.println(nome[i]);
			}
		}
		
		sc.close();
		
	}

}
