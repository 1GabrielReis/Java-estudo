package aplication;

public class derrota {

	public static void main(String[] args) {
		
		int a= 5;
		int b= 6;
		int c= 8;
		int d= 0;
		
		for(int i= 1; i < 50; i++) {
			
				d= a+b;
				a= b;
				b= c;
				c= d;
			
		}	
		
		System.out.println(c);
	}

}
