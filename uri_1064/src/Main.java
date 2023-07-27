import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		double ne, nm;
		int np, nt;
		
		ne= sc.nextDouble();
		if ( ne > 0 ) {
			np = 1 ;
			nm= ne;
		}
		else {
			np = 0;
			nm=0;
		}
		 nt = np; 
		 //-------------------------------------
		 
		 ne= sc.nextDouble();
		 if ( ne > 0) {
			 np = 1;
			 nm= ne + nm;
		 }
		 else {
			 np = 0;
			 nm= nm;
		 }
		 nt = nt + np;
		 //------------------------------------------------------
		 
		 ne= sc.nextDouble();
		 if ( ne > 0 ) {
			 np = 1;
			 nm= ne + nm;
		 }
		 else {
			 np = 0;
			 nm= nm;
		 }
		 nt= nt + np;
		 //---------------------------------------------
		 
		 ne= sc.nextDouble();
		 if ( ne > 0 ) {
			 np = 1;
			 nm= ne + nm;
		 }
		 else {
			 np = 0;
			 nm= nm;
		 }
		 nt= nt + np;
		 //---------------------------------------------
		 
		 ne= sc.nextDouble();
		 if ( ne > 0 ) {
			 np = 1;
			 nm= ne + nm;
		 }
		 else {
			 np = 0;
			 nm= nm;
		 }
		 nt= nt + np;
		 //------------------------------------
		 
		 ne= sc.nextDouble();
		if ( ne > 0 ) {
			np = 1;
			nm= ne + nm;
		}
		else {
			np = 0;
			nm= nm;
		}
		
		nt= nt + np;
		nm= nm / nt;
		//-------------------------------
		
		System.out.println(nt +" valores positivos");
		System.out.println(nm);
		
		sc.close();
		
	}

}
