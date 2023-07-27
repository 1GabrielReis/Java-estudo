package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		//String strPath= "C:\\Users\\Gabriel Reis\\OneDrive\\Documentos\\Estudos java\\Java completo\\conteudo\\18 arquivos\\input.txt";
		
		List<Product> list= new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String sourceFileStr= sc.nextLine();
		
		File sourceFile= new File(sourceFileStr);
		String sourceFolderStr= sourceFile.getParent();
		//System.out.println(sourceFolderStr);
		
		//Cirando um pasta
		boolean success= new File(sourceFolderStr+"\\out").mkdir();
		//System.out.println("Folder created: "+ success);
		
		//Criado um arquivo txt dento da pasta 
		String targetFileStr= sourceFolderStr+"\\out\\summary.txt";
		
		try(BufferedReader br= new BufferedReader(new FileReader(sourceFileStr))){
			
			String itemTxt= br.readLine(); // pular linha
			while(itemTxt != null) {
				
				/* as virgulas(,) de cada linha 
				 * do arquivo intemTxt sera um divisor
				 * de informação */
				String[] fields= itemTxt.split(",");
				String name= fields[0];
				double price= Double.parseDouble(fields[1]);
				int quantity= Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));
				
				itemTxt= br.readLine();
			}
			
			try(BufferedWriter bw= new BufferedWriter(new FileWriter(targetFileStr))){
				
				for(Product item: list) {
					bw.write(item.getName()+", "+ String.format("%.2f ",item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr+ "CREATED");
				
			}
			catch(IOException e) {
				System.out.println("Error writing file : "+ e.getMessage());
			}
			
		}
		catch(IOException e) {
			System.out.println("Error writing file : "+ e.getMessage());
		}
		
		sc.close();
		
		

	}

}
