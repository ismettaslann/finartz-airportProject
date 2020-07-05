package finartz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class FlightEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "routeId")
    private String routeId;
    
    @Column(name = "flightDate")
    private String flightDate;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "seatCount")
    private int seatCount;
    
    @Column(name = "flightAirlineID")
    private int flightAirlineID;
    
    @Column(name = "remainSeatCount")
    private int remainSeatCount;
    
    public FlightEntity() {
    	
    }

	public FlightEntity(int id, String routeId, String flightDate, double price, int seatCount, int flightAirlineID,
			int remainSeatCount) {
		
		this.routeId = routeId;
		this.flightDate = flightDate;
		this.price = price;
		this.seatCount = seatCount;
		this.flightAirlineID = flightAirlineID;
		this.remainSeatCount = remainSeatCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public int getflightAirlineID() {
		return flightAirlineID;
	}

	public void setflightAirlineID(int flightAirlineID) {
		this.flightAirlineID = flightAirlineID;
	}

	public int getRemainSeatCount() {
		return remainSeatCount;
	}

	public void setRemainSeatCount(int remainSeatCount) {
		this.remainSeatCount = remainSeatCount;
	}
    
    
    
}
