package entidade;

public  abstract class Pessoa {
	
	
	private Double rendaAnual;
	private String nome;
	
	// construtores 
	public Pessoa() {
		
	}
	public Pessoa(Double rendaAnual, String nome) {
		this.rendaAnual=rendaAnual;
		this.nome=nome;
	}
	
	// get seet
	public Double getRendaAnual() {
		return rendaAnual;
	}
	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual=rendaAnual;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	// metodo
	public abstract Double imposto();
}
