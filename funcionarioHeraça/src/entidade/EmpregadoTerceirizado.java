package entidade;

public final class EmpregadoTerceirizado extends Empregado{
	private Double despeza;
	
	// construtor 
	public EmpregadoTerceirizado() {
		super();
	}

	public EmpregadoTerceirizado(String nome, Integer horas, Double valorHora, Double despeza) {
		super(nome, horas, valorHora);
		this.despeza= despeza;
	}
	
	// get set
	public Double getDespeza() {
		return despeza;
	}
	public void setDespeza(Double despeza) {
		this.despeza= despeza;
	}

	// metodos
	@Override
	public Double pagamento() {
		return super.pagamento() + (despeza* 1.10);
	}
	
	
	
	

}
