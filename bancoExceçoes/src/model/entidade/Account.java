package model.entidade;

import molde.exceção.DominioExceção;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	// costrutores 
	public Account() {
		
	}
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number=number;
		this.holder=holder;
		this.balance=balance;
		this.withdrawLimit=withdrawLimit;
	}
	
	//get set 
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number=number;
	}
	
	public String getHolder() {
		return holder;
	}
	public void setHulder(String holder) {
		this.holder= holder;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance=balance;
	}
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit=withdrawLimit;
	}
	
	
	//metodo
	public void deposit(Double amount) {
		balance += amount;
	}
	public void withdraw(Double amount) {
		validathWithdraw(amount);
		balance -= amount;
	}
	
	
	/* tramento de  exceção
	 * 3 caso: tratando as excepção de dorma personalizada 	*/
	private void validathWithdraw(Double amount) {
		if(getBalance() >= amount && getWithdrawLimit() < amount) {
			throw new DominioExceção( "Erro de retirada: o valor excede o limite de saque ");
		}
		if(getBalance() < amount && getWithdrawLimit() < amount ) {
			throw new DominioExceção("Erro de retirada: o valor excede o limite de retirada ");
		}
		if (getBalance() < amount && getWithdrawLimit() > amount) {
			throw new DominioExceção("Erro de saque: saldo insuficiente "); 
		}
	}
	
	
	
	/*tratamento de  exceção
	 * 2 caso: ruim	
	 *Tramento considerado ruim devido:
	 * Não vai arrumar a exceção, so retorna um String
	 
	public String  validathWithdraw(Double amount) {
		
		if(getBalance() >= amount && getWithdrawLimit() < amount) {
			return "Erro de retirada: o valor excede o limite de saque ";
		}
		if(getBalance() < amount && getWithdrawLimit() < amount ) {
			return "Erro de retirada: o valor excede o limite de retirada ";
		}
		if (getBalance() < amount && getWithdrawLimit() > amount) {
			return "Erro de saque: saldo insuficiente "; 
		}
		return null;
	}
	*/
	
	
	
}
