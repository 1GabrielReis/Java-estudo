import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int rest, inter, interP, gremio, gremioP, empate, grenais ;
		
		rest= 1;
		interP= 0;
		gremioP= 0;
		empate= 0;
		
		
		while ( rest == 1) {
			
			inter= sc.nextInt();
			gremio= sc.nextInt();
			
			if ( inter > gremio) {
				interP =+1;
			}
			else if ( inter < gremio) {
				gremioP =+ 1;
			}
			else {
				empate =+ 1;
			}
			
			
			System.out.println("Novo grenal (1-sim 2-nao)");
			rest= sc.nextInt();
			
		}
		
			grenais= interP+ gremioP+ empate;
			System.out.println( grenais + " grenais");
			System.out.println("Inter: "+ interP);
			System.out.println("Gremio: "+ gremioP);
			System.out.println("Empates: "+ empate);
			if (interP > gremioP) {
				System.out.println("Inter venceu mais");
			}
			else if (interP < gremioP) {
				System.out.println("Gremio venceu mais");
			}
			else {
				System.out.println("Nao houve vencedor");
			}
			sc.close();
		
		
		sc.close();
	}

}
