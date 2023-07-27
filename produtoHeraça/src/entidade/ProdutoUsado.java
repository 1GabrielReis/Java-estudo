package entidade;

import java.text.SimpleDateFormat;
import java.util.Date;



public final class ProdutoUsado extends Produto {
	
	private static final SimpleDateFormat formatoData= new SimpleDateFormat("dd/MM/yyyy"); 
	
	private Date fabri�aoData;
	
	// construtores 
	public ProdutoUsado() {
		super();
	}
	public ProdutoUsado(String nome, Double pre�o, Date fabri�aoData) {
		super(nome, pre�o);
		this.fabri�aoData= fabri�aoData;
	}
	
	// get e set 
	public Date getFabricaoData() {
		return fabri�aoData;
	}
	public void setFabri�aoData(Date fabri�aoData) {
		this.fabri�aoData= fabri�aoData;
	}
	
	// metodos 
	// toString
	@Override
	public String toString() {
		return getNome()+ " (usado) - R$: "+String.format("%.2f", getPre�o())+" "+ formatoData.format(fabri�aoData)+ " ";
	}
	
}
