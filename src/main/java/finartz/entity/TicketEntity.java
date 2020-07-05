package finartz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicketEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "ticketNumber")
	private String ticketNumber;
	
	@Column(name = "cardNumber")
	private String cardNumber;
	
	@Column(name = "flightId")
	private Integer flightId;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "passengerIdendityNumber")
	private String passengerIdendityNumber;
	
	@Column(name = "passengerName")
	private String passengerName;
	
	@Column(name = "seatInfo")
	private String seatInfo;
	
	@Column(name = "status")
	private String status;
	
	public TicketEntity() {
		
	}
	
	public TicketEntity(int id, String ticketNumber, String cardNumber, Integer flightId, Double price,
			String passengerIdendityNumber, String passengerName, String seatInfo, String status) {
		super();
		this.id = id;
		this.ticketNumber = ticketNumber;
		this.cardNumber = cardNumber;
		this.flightId = flightId;
		this.price = price;
		this.passengerIdendityNumber = passengerIdendityNumber;
		this.passengerName = passengerName;
		this.seatInfo = seatInfo;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPassengerIdendityNumber() {
		return passengerIdendityNumber;
	}
	public void setPassengerIdendityNumber(String passengerIdendityNumber) {
		this.passengerIdendityNumber = passengerIdendityNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getSeatInfo() {
		return seatInfo;
	}
	public void setSeatInfo(String seatInfo) {
		this.seatInfo = seatInfo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
