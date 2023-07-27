package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		String sourceFileStr="C:\\Users\\Gabriel Reis\\OneDrive\\Documentos\\Estudos java\\Java completo\\conteudo\\21 programacao funcional expressoes lambda\\input.txt";
		File sourceFile= new File(sourceFileStr);
		
		String sourceFolderStr= sourceFile.getParent(); //pega somente o caminho 
		boolean success= new File(sourceFolderStr+"\\out").mkdir(); // criando arquivo
		String targetFileStr= sourceFolderStr+"\\out\\summary.txt"; // cirando pasta
		
		
		System.out.println("Insira o salário: base");
		double baseSalary= sc.nextDouble();
		
		System.out.println("Letra incial:");
		char letter= sc.next().charAt(0);
		
		System.out.println("E-mail de pessoas cujo salário é superior a "+String.format("%.2f", baseSalary)+": ");
		
		try(BufferedReader br= new BufferedReader(new FileReader(sourceFileStr))){
			
			List<Employee> list= new ArrayList<>();
			String line= br.readLine();
			
			while(line != null) {
				String[] fields= line.split(",");
				String name= fields[0];
				String email= fields[1];
				double salary= Double.parseDouble(fields[2]);
				
				list.add(new Employee(name, email, salary));
				line= br.readLine();	
			}
			
			Comparator<String> comp= (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> emailList= list.stream()
					.filter(p -> p.getSalary() > baseSalary)
					.map(p -> p.getEmail())
					.sorted(comp)
					.collect(Collectors.toList());
			
			emailList.forEach(System.out::println);
			
			double totalLetter= list.stream()
					.filter(p -> p.getName().charAt(0) == letter)
					.map(p -> p.getSalary())
					.reduce(0.0,(x, y) -> x+ y);
			
			System.out.println("Soma do salário de pessoas cujo nome começa com '"+letter+"' :"+String.format(" %.2f", totalLetter));
			
		
			
			try(BufferedWriter bw= new BufferedWriter(new FileWriter(targetFileStr))){
				
				bw.write("Email: ");
				bw.newLine();
				for(String brand: emailList) {
					bw.write(brand.toString());
					bw.newLine();
				}
		
				bw.write("Soma do salário de pessoas cujo nome começa com '"+letter+"' :"+String.format(" %.2f", totalLetter));
				bw.newLine();
				System.out.println("CREATED");
			}
			catch(IOException e) {
				System.out.println("Erro na gravação irmão");
			}
		}
		catch(IOException e) {
			System.out.println("Erro na leitura irmão");
		}
		finally {
			sc.close();
		}
		
		
	}

}
