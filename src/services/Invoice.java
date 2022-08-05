package services;

public class Invoice {

	public double finalPrice(Rental rental, Tax tax) {
		
		return rental.totalPrice() + tax.priceAfterTax(rental.totalPrice());
	}
	
	public String toString(Rental rental, Tax tax) {
		
		return "Basic payment: " + String.format("%.2f", rental.totalPrice()) + "\n" 
				+ "Tax: " + String.format("%.2f", tax.priceAfterTax(rental.totalPrice())) + "\n"
				+ "Total payment: " + String.format("%.2f", finalPrice(rental, tax));
		
	}
	
}
