package application;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;



public class Program {

	public static void main(String[] args) throws ParseException {

		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());

		CarRental car = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Enter price per day: ");
		double pd = sc.nextDouble();
		System.out.print("Enter price per hour: ");
		double ph = sc.nextDouble();
		
		RentalService rental = new RentalService(pd, ph, new BrazilTaxService());
		
		rental.processInvoice(car);
		
		System.out.println("INVOICE");
		System.out.print("Basic payment: " + String.format("%.2f", car.getInvoice().getBasicPayment()));
		System.out.print("Tax: " + String.format("%.2f", car.getInvoice().getTax()));
		System.out.print("Total payment: " + String.format("%.2f", car.getInvoice().getTotalPayment()));
		
		
		
		
		
		
		sc.close();
	}

}