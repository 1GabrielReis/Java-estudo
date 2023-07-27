import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int i, N, lucroB, lucroM, lucroA;
		double lucro, compraT, vendaT, retornoT;
		
		double[] compra, venda;
		String[] nome;
		
		N= sc.nextInt();
		
		nome= new String[N];
		compra= new double[N];
		venda= new double[N];
		
		for ( i= 0; i< N; i++) {
			nome[i]= sc.next();
			compra[i]= sc.nextDouble();
			venda[i]= sc.nextDouble();
		}
		
		
		lucroB= 0;
		lucroM= 0;
		lucroA= 0;
		
		for ( i= 0; i< N; i++) {
			lucro= ( venda[i] - compra[i]) * 100 / compra[i];
			
			if ( lucro < 10) {
				lucroB += 1;
			}
			else if ( lucro >= 10 && lucro <= 20){
				lucroM += 1;
			}
			else {
				lucroA += 1;
			}
		}
		
		compraT= 0;
		vendaT= 0;
		retornoT= 0;
		for ( i= 0; i< N; i++) {
			compraT += compra[i];
			vendaT += venda[i];
			retornoT = vendaT - compraT;
		}
		
		System.out.println("Lucro abaixo de 10%: "+ lucroB);
		System.out.println("Lucro entre 10% e 20%: "+ lucroM);
		System.out.println("Lucro acima de 20%: "+ lucroA);
		System.out.println("Valor total de compra: "+ compraT);
		System.out.println("Valor total de venda: "+ vendaT);
		System.out.printf("Lucro total: %.2f%n ", retornoT);
		
		sc.close();
		

	}

}
