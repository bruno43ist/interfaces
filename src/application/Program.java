package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.Paypal;
import model.services.ProcessingService;

public class Program {

	public static void main(String[] args) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date: ");
		sc.nextLine();
		Date startDate = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		Double value = sc.nextDouble();
		
		Contract contract = new Contract(number, startDate, value);
		
		System.out.print("Enter number of installments: ");
		int numberOfInstallments = sc.nextInt();
		
		ProcessingService processingService = new ProcessingService(new Paypal());
		
		processingService.processContract(contract, numberOfInstallments);
		
		System.out.println("INSTALLMENTS: ");
		System.out.println(contract);
		
		sc.close();

	}

}
