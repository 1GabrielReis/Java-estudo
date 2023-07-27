package services;

import java.time.LocalDate;

import entidade.Contract;
import entidade.Installment;

public class ContractService {
	
	private OnlinePaymentSrevice onlinePaymentSrevice;

	public ContractService(OnlinePaymentSrevice onlinePaymentSrevice) {
		this.onlinePaymentSrevice = onlinePaymentSrevice;
	}
	
	public void processContract(Contract obj, Integer months) {
		
		Double installmenValue= obj.getTotalValue()/months;
		
		for(int i= 1; i<= months; i++) {
			//date
			LocalDate dueDate= obj.getDate().plusMonths(i); // plusMonths: adicionar mes
			//valor
			Double fees= onlinePaymentSrevice.interest(installmenValue, i);
			Double tax= onlinePaymentSrevice.paymentFee(fees+ installmenValue);
			Double quota= installmenValue+ fees+ tax; 
			
			obj.getInstalments().add(new Installment(dueDate,quota));
		}
  	
		
	}
	
	
	
}
