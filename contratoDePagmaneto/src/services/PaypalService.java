package services;

public class PaypalService implements OnlinePaymentSrevice {
	
	@Override
	public Double paymentFee(Double amount) { //taxa de pagamento
		return amount* 0.02;
	}
	@Override
	public Double interest(Double amount, Integer months) { //months= messes
		return amount* (months*0.01);
	}
	
}
