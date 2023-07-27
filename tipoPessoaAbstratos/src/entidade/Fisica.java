package entidade;

public final class Fisica extends Pessoa{
	private Double gastoSaude;
	
	//construtores
	public Fisica() {
		super();
	}
	public Fisica(Double rendaAnual, String nome, Double gastoSaude) {
		super(rendaAnual, nome);
		this.gastoSaude= gastoSaude;
	}
	
	//get set
	public Double getGastoSaude() {
		return gastoSaude;
	}
	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude=gastoSaude;
	}
	
	
	@Override
	public Double imposto() {
		// Double imposto= (getRendaAnual() < 20000.0) ?  0.15 : 0.25;
		Double imposto= 0.00;
		if (getRendaAnual() < 20000.0) {
			imposto= 0.15;
		}
		else {
			imposto= 0.25;
		}
		return (imposto* getRendaAnual())-(0.5*gastoSaude);
	}
	
	

}
