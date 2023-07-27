import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double ne;
		int np, nt;
		
		ne= sc.nextDouble();
		if ( ne > 0 ) {
			np = 1 ;
		}
		else {
			np = 0;
		}
		 nt = np;
		 
		 ne= sc.nextDouble();
		 if ( ne > 0) {
			 np = 1;
		 }
		 else {
			 np = 0;
		 }
		 nt = nt + np;
		 
		 ne= sc.nextDouble();
		 if ( ne > 0 ) {
			 np = 1;
		 }
		 else {
			 np = 0;
		 }
		 nt= nt + np;
		 
		 ne= sc.nextDouble();
		 if ( ne > 0 ) {
			 np = 1;
		 }
		 else {
			 np = 0;
		 }
		 nt= nt + np;
		 
		 ne= sc.nextDouble();
		 if ( ne > 0 ) {
			 np = 1;
		 }
		 else {
			 np = 0;
		 }
		 nt= nt + np;
		 
		 ne= sc.nextDouble();
		if ( ne > 0 ) {
			np = 1;
		}
		else {
			np = 0;
		}
		
		nt= nt + np;
		
		System.out.println(nt +" valores positivos");
		
		sc.close();
		
	}

}
