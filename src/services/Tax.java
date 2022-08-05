package services;

public class Tax {

	public double priceAfterTax(double totalPrice) {
		
		if (totalPrice <= 100)
		return 0.2 * totalPrice;
		
		if (totalPrice > 100) {
			return 0.15 * totalPrice;
		}
		return 0;
	}
	
}
