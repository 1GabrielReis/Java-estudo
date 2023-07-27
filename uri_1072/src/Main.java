import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);
		
		int N, X, i, in, out;
		
		N= sc.nextInt();
		
		in= 0;
		out= 0;
		
		for(i= 1; i <= N; i++) {
			X= sc.nextInt();
			
			if ( X >= 10 && X <= 20) {
				in += 1;
			}
			else {
				out += 1;
			}
		}
		System.out.println(in+" in ");
		System.out.println(out+" out ");
		
		sc.close();
	}

}
