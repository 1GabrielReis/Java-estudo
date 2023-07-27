package entidade;

public class Empregado {
	private String nome;
	private Integer horas;
	private Double valorHora;
	
	// construtores 
	public Empregado() {
		
	}
	public Empregado(String nome, Integer horas, Double valorHora) {
		this.nome= nome;
		this.horas=horas;
		this.valorHora= valorHora;
	}
	
	// get set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas= horas;
	}
	
	public Double getValorHora() {
		return valorHora;
	}
	public void setValorHora(Double valorHora) {
		this.valorHora= valorHora;
	}
	
	// metodos 
	public Double pagamento() {
		return horas* valorHora;
	}
	
	

}
	
