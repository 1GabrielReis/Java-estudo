package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Map<String, Integer> votes= new HashMap<>();
		
		System.out.println("numero de urnas");
		int n= sc.nextInt();
		
		for (int i= 0; i< n; i++) {
			sc.nextLine();
			System.out.println("nome do cadidato");
			String nome= sc.nextLine();
			System.out.println("numero de votos");
			int count= sc.nextInt();
			
			if(votes.containsKey(nome)) {
				int votuesN= votes.get(nome);
				votes.put(nome, count+ votuesN);
			}
			else {
				votes.put(nome, count);
			}
		}
		for(String key: votes.keySet()) {
			System.out.println(key+" "+votes.get(key));
		}
	}

}
