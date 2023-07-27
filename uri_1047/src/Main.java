import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		int hi, hf, ht, mi, mf, mt;
		
		hi= sc.nextInt();
		mi= sc.nextInt();
		hf= sc.nextInt();
		mf= sc.nextInt();
		
		if  ( hi <= hf) {
		ht= ((hf- hi) * 60 - mi + mf) / 60;
		mt= ((hf- hi) * 60 - mi + mf) % 60;
		
		System.out.println("O JOGO DUROU "+ ht+ " HORA(S) E "+ mt+ " MINUTO(S)");
		}
		else {
			if ( hi > hf) {
				ht= ((24- hf+ hi ) * 60 - mi + mf) / 60;
				mt= ht= ((24- hf+ hi ) * 60 - mi + mf) % 60;
				
				System.out.println("O JOGO DUROU "+ ht+ " HORA(S) E "+ mt+ " MINUTO(S)");
			}
		}
			
		
		sc.close();
		

	}

}
