package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;

public class ProcessingService {
	 
	private PaymentService paymentService;
	
	public ProcessingService() {
		
	}
	
	public ProcessingService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}



	public void processContract(Contract contract, int numberOfInstallments) {
		Double value = contract.getTotalValue();
		Date startDate = contract.getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		Double installmentFreeAmount = (double) value / (double)numberOfInstallments;
		
		for(int i = 1; i <= numberOfInstallments; i++) {
			cal.add(Calendar.MONDAY, 1);//adiciona um mês na data do calendário
			Date newDate = cal.getTime();//retorna a data com um mês a mais na variavel newDate
			contract.newInstallment(newDate, paymentService.amount(installmentFreeAmount, i));//adiciona uma nova parcela à lista de parcelas do contrato
		}
	}
}
