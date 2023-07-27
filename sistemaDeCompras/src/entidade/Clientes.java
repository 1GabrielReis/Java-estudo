package entidade;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clientes {
	
	private SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
	
	private String nome;
	private String email;
	private Date dataNascimento;
	
	// Construtores
	public Clientes() {
		
	}
	public Clientes( String nome, String email, Date dataNascimento) {
		this.nome= nome;
		this.email= email;
		this.dataNascimento= dataNascimento;
		
	}
	
	//get e set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento=dataNascimento;
	}
	
	@Override
	public String toString() {
		StringBuilder textoFormato= new StringBuilder();
		textoFormato.append("Cliente: ");
		textoFormato.append(getNome()+" ");
		textoFormato.append(formato.format(getDataNascimento())+"  - ");
		textoFormato.append(getEmail());
		return textoFormato.toString();
	}

}
