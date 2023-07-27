import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int diaI, diaF, horaI, horaF, minutoI, minutoF, segundoI, segundoF, tempoI, tempoF, tempo;
		double tempoT;
		
		// Inicio
		diaI= sc.nextInt();
		horaI= sc.nextInt();
		minutoI= sc.nextInt();
		segundoI= sc.nextInt();
		
		// Final
		diaF= sc.nextInt();
		horaF= sc.nextInt();
		minutoF= sc.nextInt();
		segundoF= sc.nextInt();
		
		tempoI= diaI* 86400+ horaI* 3600+ minutoI* 60+ segundoI;
		tempoF= diaF* 86400+ horaF* 3600+ minutoF* 60+ segundoF; 
		tempoT= (double) tempoF - tempoI;
		
		tempo= (int) tempoT/ 86400;
		System.out.printf("%d dia(s)%n", tempo);
		tempoT= tempoT% 86400;
		
		tempo= (int) tempoT/ 3600;
		System.out.printf("%d hora(s)%n", tempo);
		tempoT= tempoT% 3600;
		
		tempo= (int)tempoT/ 60;
		System.out.printf("%d minuto(s)%n", tempo);
		tempoT= tempoT% 60;
		
		tempo= (int) tempoT/ 1;
		System.out.printf("%d segundo(s)%n", tempo);
		tempoT= tempoT% 1;
		
		sc.close();
		

		
	}

}
