import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner( System.in);
		
		String x1, x2, x3;
		
		x1= sc.nextLine();
		x2= sc.nextLine();
		x3= sc.nextLine();
		
		if ( x1.equals("vertebrado")) {   // x1
			
			if ( x2.equals("ave")) {  //x2
				
				if (x3.equals("carnivoro")) {
					
					System.out.println(" aguia ");
				}
				else if (x3.equals("onivoro")){
					
					System.out.println(" pomba ");
				}
			}
			
			else if ( x2.equals("mamifero")) {  //x2
				
				if (x3.equals("onivoro")) {
					
					System.out.println(" homem ");
				}
				else if (x3.equals("herbivoro")) {
					
					System.out.println(" vaca ");
				}
			}
		}
		else if (x1.equals("invertebrado")) { //x1
			
			if (x2.equals("inseto")) {  //x2
				
				if (x3.equals("hematofago")) {
					
					System.out.println(" pulga ");
				}
				else if (x3.equals(" herbivoro")) {
					
					System.out.println(" largata");
				}
			}
			else if (x2.equals("anelideo")) { //x2
				
				if (x3.equals("hematofago")) {
					
					System.out.println(" sanguessuga ");
				}
				else if (x3.equals("onivoro")) {
					
					System.out.println(" minhoca ");
				}
			}
		}
		
		
		sc.close();
	}

}
