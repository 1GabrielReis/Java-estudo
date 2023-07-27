import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int i, N, maior, posicao;
		
		 maior= sc.nextInt();
		 posicao= 1;
		 
		 for ( i= 2; i <= 5; i++) {
			 
			 N= sc.nextInt();
			 
			 if ( N > maior) {
				 maior= N;
				 posicao= i;
			 }
		 }
		 
		 System.out.println(maior);
		 System.out.println(posicao);
		 
		 sc.close();
		
		
		

	}

}




//maior= 0;
//posicao= 0;


//for ( i= 1; i <= 5; i++ ) {
	
	//N= sc.nextInt();
	
	//if ( i == 1) {
		//maior= N;
		//posicao= i;
	//}
	
	
	//if ( maior < N ) {
		
	//maior = N;
	//posicao= i;
		
	//}
	
	
//}

//System.out.println(maior);
//System.out.println(posicao);
