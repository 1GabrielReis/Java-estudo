package entidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	private Integer number; //numero
	private LocalDate date; // data
	private Double totalValue; //valor total
	
	private List<Installment> instalments= new ArrayList<>();
	
	//private Installment installment;
	
	// construtor
	public Contract() {
		
	}
	public Contract(Integer number, LocalDate date, Double totalValue) {
		this.number= number;
		this.date= date;
		this.totalValue= totalValue;
	}
	
	//get e set
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number= number;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date= date;
	}
	
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue= totalValue;
	}
	
	public List<Installment> getInstalments() {
		return instalments;
	}

		
	
	
}
