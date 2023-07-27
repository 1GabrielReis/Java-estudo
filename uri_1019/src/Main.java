import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int N, seg, min, hora, resto;
		
		N= sc.nextInt();
		
		hora= N/ 3600;
		resto= N% 3600;
		min= resto/ 60;
		seg= resto% 60;
		
		System.out.println (hora+ ":"+ min+ ":"+ seg);
		
		sc.close();

	}

}
