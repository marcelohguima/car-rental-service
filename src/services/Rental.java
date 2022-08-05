package services;

import java.util.Calendar;
import java.util.Date;


public class Rental {

	private Date pickupCar;
	private Date returnCar;
	private double pricePerHour;
	private double pricePerDay;
	
	public Rental(Date pickupCar, Date returnCar, double pricePerHour, double pricePerDay) {
		this.pickupCar = pickupCar;
		this.returnCar = returnCar;
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
	}

	public Date getPickupCar() {
		return pickupCar;
	}

	public void setPickupCar(Date pickupCar) {
		this.pickupCar = pickupCar;
	}

	public Date getReturnCar() {
		return returnCar;
	}

	public void setReturnCar(Date returnCar) {
		this.returnCar = returnCar;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
	public double totalPrice() {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.setTime(pickupCar);
		cal2.setTime(returnCar);
		
		if (this.returnCar.getTime() - pickupCar.getTime() <= 43200000) {
			
			return Math.ceil((double)(this.returnCar.getTime() - pickupCar.getTime()) / 1000 / 60 / 60) * this.pricePerHour;
			
		}
		
		if (this.returnCar.getTime() - pickupCar.getTime() > 43200000) {
			if (cal2.get(Calendar.HOUR) - cal.get(Calendar.HOUR) != 0) {
				return this.pricePerDay * ((cal2.get(Calendar.DAY_OF_MONTH)+ 1) - cal.get(Calendar.DAY_OF_MONTH));
			}
			
			else {
				return this.pricePerDay * ((cal2.get(Calendar.DAY_OF_MONTH)) - cal.get(Calendar.DAY_OF_MONTH));
			}
		}
		return 0;
	}
	
	
}
