package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;
	private TaxService taxService;
	
	public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxServices taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();//pega o valor em milissegundos
		long t2 = carRental.getFinish().getTime();//'
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;////retorna a diferença em horas entre as datas
		
		double basicPayment;
		
		if(hours <= 12) {
			basicPayment = Math.ceil(hours) * pricePerHour;//tarifa que deve para a locadora
		} else {
			basicPayment = Math.ceil(hours/24) * pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment);//retorna o imposto a ser pago
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
	
}
