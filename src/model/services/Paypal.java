package model.services;

public class Paypal implements PaymentService{
	
	@Override
	public Double amount(double amount, int month) {
		Double simpleInterestPerMonth = amount * 0.01 * month;
		amount += simpleInterestPerMonth;
		Double paymentFee = amount * 0.02;
		return (amount + paymentFee);
		
	}
}
