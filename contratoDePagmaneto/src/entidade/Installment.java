package entidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	public static DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate dueDate;  // data  vencimento
	private Double amount; 		// montante
	
	//construtor 
	public Installment() {
		
	}
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate= dueDate;
		this.amount= amount;
	}
	
	// get e set 
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate= dueDate;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount= amount;
	}
	
	// era necessario colocar toString
	@Override
	public String toString() {
		return getDueDate().format(fmt)+ " - " + String.format("%.2f ", getAmount());
	}

}
