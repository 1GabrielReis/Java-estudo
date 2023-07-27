package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		Map<String, Integer> votues= new HashMap<>();
		
		
		String sourceFileStr="C:\\Users\\Gabriel Reis\\OneDrive\\Documentos\\Estudos java\\Java completo\\conteudo\\20 generics-set-map\\input.txt";
		File sourceFile= new File(sourceFileStr);
		String sourceFolderStr= sourceFile.getParent();
		boolean success= new File(sourceFolderStr+"\\out").mkdir(); //criando pasta
		String targetFileStr= sourceFolderStr+"\\out\\summary.txt"; //criando arquivo
		
		try(BufferedReader br= new BufferedReader(new FileReader(sourceFileStr))){
			
			String line= br.readLine();
			
			
			while(line != null) {
				String[] fields= line.split(",");
				String name= fields[0];
				int count= Integer.parseInt(fields[1]);
				
				if(votues.containsKey(name)) {
					int votuesN= votues.get(name); // valor que tem a chave name
					votues.put(name, votuesN+ count);
				}
				else {
					votues.put(name, count);
				}
				
				line=br.readLine();
			}
			for(String key: votues.keySet()) {
				System.out.println(key+ " "+votues.get(key));
			}
			try(BufferedWriter bw= new BufferedWriter(new FileWriter(targetFileStr))){
				for(String key: votues.keySet()) {
					bw.write(key+", "+votues.get(key));
					bw.newLine();
				}
				System.out.println(targetFileStr+ "CREATED");
			}
			catch(IOException e) {
				System.out.println("Erro irmão");
			}
			
		}
		catch(IOException e) {
			System.out.println("Erro irmão");
		}
		 finally{
			System.out.println();
		}
		
	}

}
