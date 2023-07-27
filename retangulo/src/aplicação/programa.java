package aplicação;

import java.util.Locale;
import java.util.Scanner;
import objeto.retangulo;



public class programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		retangulo medida;
		medida = new retangulo();
		
		
		System.out.println("Qual a largura do retagulo:");
		medida.largura= sc.nextDouble();
		System.out.println("Qual o comprimento do retangulo:");
		medida.comprimento= sc.nextDouble();
		
		
		double medidaArea= medida.area();
		double medidaPerimetro= medida.perimetro();
		double medidaDiagonal= medida.diagonal();
		
		System.out.printf("Area= %.2f %n",  medidaArea);
		System.out.printf("Perimetro= %.2f %n", medidaPerimetro);
		System.out.printf("Diagonaç= %.2f %n", medidaDiagonal);
		
		sc.close();
		
		

	}

}
