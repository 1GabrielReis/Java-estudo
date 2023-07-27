import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
Scanner sc=  new Scanner(System.in);
		
		int n1, n2, n3, A , B,  C;
		
		n1= sc.nextInt();
		n2= sc.nextInt();
		n3= sc.nextInt();
		
		if ( n1 > n2 && n1 > n3) {
			A= n1;
			if ( n2 > n3) {
				B= n2;
				C= n3;
			}
			else {
				B= n3;
				C= n2;
			}
		}
		else if ( n2 > n3) {
			A= n2;
			if ( n1 > n3) {
				B= n1;
				C= n3;
			}
			else {
				B= n3;
				C= n1;
			}
		}
		else {
			A= n3;
			if (  n1 > n2) {
				B= n1;
				C= n2;
			}
			else {
				B= n2;
				C= n1;
			}
		}
		
		System.out.println(C);
		System.out.println(B);
		System.out.println(A);
		System.out.println("");
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		
		sc.close();

	}

}
