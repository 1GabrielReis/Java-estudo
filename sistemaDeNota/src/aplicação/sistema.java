package aplicação;

import java.util.Locale;
import java.util.Scanner;

public class sistema {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		
		int N, M,  somar, exibir, i, j;
		double[] media;
		String[] nome, resultado;
		int[][] nota;
		
		somar= 0;
		exibir= 0;
		
		System.out.println("Numero de aluno: ");
		N= sc.nextInt();
		System.out.println("Numero de notas:");
		M= sc.nextInt();
		
		media= new double[N];
		nome= new String[N];
		resultado= new String[N];
		nota= new int[N][M];
		
		for( i= 0; i< N; i++){
			System.out.println("Nome do aluno: ");
			nome[i]= sc.next();
			for( j= 0; j< M; j++){
				exibir= j+ 1;
				System.out.println("Nota"+exibir+": ");
				nota[i][j]= sc.nextInt();
				while(nota[i][j] < 0 || nota[i][j] > 10){
					System.out.println("Nota de 0 a 10");
					System.out.println("Nota"+exibir+": ");
					nota[i][j]= sc.nextInt();
				}
			}
		}
		
		for (i= 0; i< N; i++){
			somar= 0;
			for(j= 0; j< M; j++){
				somar += nota[i][j];
			}
			media[i]=(double) somar/ M;
		}
		
		for(i= 0; i< N; i++){
			if (media[i] >= 5){
				resultado[i]= "APROVADO";
			}
			else if (media[i]< 5 && media[i]>= 3){
				resultado[i]= "RECUPERAÇAO";
			}
			else {
				resultado[i]= "REPROVADO";
			}
			
		}
		
		for (i= 0; i< N; i++){
			System.out.print(" Nome: "+ nome[i]+" Notas:" );
			for (j= 0; j< M; j++){
				System.out.print(" "+ nota[i][j]);
			}
			System.out.printf(" Media: %.1f %s %n",media[i], resultado[i]);
			
		}
		
		
		
		sc.close();
		

	}

}
