package entities;

public class Conta {
	
	private int digitoConta;
	private String nome;
	private  char depositoIncial;
	private  double valorConta;
	
	
	//contrutores
	public Conta() {
		
	}
	
	public Conta (int digitoConta, String nome, char depositoIncial) {
		this.digitoConta= digitoConta;
		this.nome= nome;
		this.depositoIncial= depositoIncial;
	}
	
	public Conta (int digitoConta, String nome, char depositoIncial, double primeiroDeposito) {
		this.digitoConta= digitoConta;
		this.nome= nome;
		this.depositoIncial= depositoIncial;
		deposito(primeiroDeposito);
	}
	
	// get e set
	public int getDigitoConta() {
		return digitoConta;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome (String nome) {
		this.nome= nome;
	}
	
	public char getDepositoIncial() {
		return depositoIncial;
	}
	public void setDepositoIncial(char DepositoIncial) {
		this.depositoIncial= DepositoIncial;
	}
	
	public double getValorConta() {
		return valorConta;
	}
	
	
	// metodos
	public double deposito(double valorConta) {
		return  this.valorConta += valorConta;
	}
	
	public double saca(double valorConta) {
		return this.valorConta -= (valorConta+ 5);
	}
	
	
	public String toString() {
		return "Account data:"+ getDigitoConta() +", Holder: "+ getNome()+ ", Balance: $ "
				+ String.format("%.2f", getValorConta());
	}
	
	
	

}
