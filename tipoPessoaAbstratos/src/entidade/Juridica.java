package entidade;

public class Juridica extends Pessoa {
	private int numeroFuncionarios;
	
	// construtores 
	public Juridica() {
		super();
	}
	public Juridica(Double rendaAnual, String nome, Integer numeroFuncionarios) {
		super(rendaAnual, nome);
		this.numeroFuncionarios= numeroFuncionarios;
	}
	// get set
	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}
	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios=numeroFuncionarios;
	}
	//metodo
	@Override
	public Double imposto(){
		Double imposto= 0.00;
		if( numeroFuncionarios < 10) {
			imposto= 0.16;
		}
		else {
			imposto=0.14;
		}
		return getRendaAnual()*imposto;
	}
	
}
