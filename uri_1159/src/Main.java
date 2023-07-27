import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int numero= sc.nextInt();
		
		int quantidade= 0;
		int somar= 0;
		int acrescentar=0;
		
			
		while ( numero != 0) {
			
		
			if ( numero%2 == 1) {
				numero +=1;
			}
			
			while ( acrescentar <= 4) {
			
				if ( acrescentar == 0) {
				
					somar = numero;
					acrescentar += 1;
				}
			
				else if ( acrescentar == 1) {
				
					quantidade= numero+ 2;
					somar += quantidade; 
					acrescentar += 1;
				}
				else if ( acrescentar == 2) {
				
					quantidade= numero+ 4;
					somar += quantidade;
					acrescentar += 1;
				}
				else if ( acrescentar == 3) {
				
					quantidade= numero+ 6;
					somar += quantidade;
					acrescentar += 1;
				}
				else {
				
					quantidade= numero+ 8;
					somar += quantidade;
					acrescentar += 1;
				}
			
			
			}
		
			System.out.println(somar);
			numero= sc.nextInt();
			acrescentar= 0;
		}
	}

}


//import java.util.Scanner;

//nao esqueca de mudar o nome da classe para Main
//public class uri1159 {

//	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
		
//		int x = sc.nextInt();
		
//		while (x != 0) {
			
			// se for impar, some mais 1
//			if (x % 2 != 0) {
//				x = x + 1;
//			}
			
			// expressao simplificada: 5 * x + 20
//			int soma = x + x + 2 + x + 4 + x + 6 + x + 8; 
//			System.out.println(soma);
			
//			x = sc.nextInt();
//		}
		
//		sc.close();
//	}
//}
