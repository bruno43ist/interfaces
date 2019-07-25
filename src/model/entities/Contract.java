package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer number;
	private Date date;
	private Double totalValue;
	
	List<Installment> installments = new ArrayList<>();
	
	public Contract() {
		
	}

	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public void newInstallment(Date dueDate, double amount) {
		Installment e = new Installment(dueDate, amount);
		installments.add(e);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Installment i : installments) {
			sb.append(sdf.format(i.getDueDate()));
			sb.append(" - " + String.format("%.2f", i.getAmount()) + "\n");
		}
		return sb.toString();
	}
}
