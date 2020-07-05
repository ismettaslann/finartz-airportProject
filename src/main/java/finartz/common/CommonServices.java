package finartz.common;

import java.security.SecureRandom;

public class CommonServices {

	public String maskCardNumber(String cardNumber) {
		cardNumber = cardNumber.replaceAll("[^0-9]", "");
		int length = cardNumber.length();
		StringBuilder sb = new StringBuilder();
		sb.append(cardNumber.substring(0,6));
		sb.append("******");
		sb.append(cardNumber.substring(length-4, length));
		return sb.toString();
	}
	
	public String generateTicketNumber() {
		TicketNumberGenerator ticket = new TicketNumberGenerator(12, new SecureRandom());
		return ticket.nextString();
	}

	public double calculatePriceByPercentage (int totalSeats, int remainSeats, double price) {
		double percentage = (remainSeats*100) / totalSeats;
		price = price + price*(100-percentage)/100;
		return price;
	}
}
