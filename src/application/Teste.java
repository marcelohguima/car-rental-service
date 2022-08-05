package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Car;
import services.Invoice;
import services.Rental;
import services.Tax;

public class Teste {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:ss");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		
		String model = sc.nextLine();
		
		System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
		Date pickupCar = sdf.parse(sc.nextLine());
		
		System.out.print("Return: (dd/MM/yyyy hh:ss): ");
		Date returnCar = sdf.parse(sc.nextLine());
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		Car car = new Car(model);
		Rental rental = new Rental(pickupCar, returnCar, pricePerHour, pricePerDay);
		Tax tax = new Tax();
		Invoice invoice = new Invoice();

		System.out.println(invoice.toString(rental, tax));
		
		sc.close();

	}
}
