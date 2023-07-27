package services;

public interface OnlinePaymentSrevice {
	
	public Double paymentFee(Double amount);
	public Double interest(Double amount, Integer months);
	
}
