package model.services;

public class BrazilTaxServices implements TaxService{
	
	public double tax(double amount) {
		if(amount <= 100.00) {
			return 0.2 * amount;
		}
		return amount * 0.15;
	}
}
