import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int i, N, idade, nome;
		
		int[] vetorB;
		String[] vetorA;
		
		N= sc.nextInt();
		vetorA= new String[N];
		vetorB= new int[N];
		
		for ( i= 0; i< N; i++) {
			vetorA[i]= sc.next();
			vetorB[i]= sc.nextInt();
			
		}
	
		nome= 0;
		idade= vetorB[0];
		
		for ( i= 0; i< N; i++) {
			if ( vetorB[i]> idade) {
				nome= i;
				idade= vetorB[i];
			}
		}
		System.out.println("Pessoa mais velha: "+vetorA[nome]);
		
		sc.close();
	}

}
