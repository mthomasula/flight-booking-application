package BusinessLogic;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;



public class Flight implements ObservableList {
	
	private String airline;
	private String originCity;
	private String destinationCity;
	private Time departureTime;
	private Time arrivalTime;
	private Date departureDate;
	private Date arrivalDate;
	private int flightNumber;
	private int flightCapacity;
	private int seatsOpen;
	private int seatsTaken;
	private boolean checkIfSeatFull;
	private Timestamp time;
	
	public Flight() {
		
	}
	
	public Flight(String airline, int flightNumber, String originCity, String destinationCity) {
		
		super();
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		
	}
	
	
	public Flight(String airline, String originCity, String destinationCity, int flightNumber, int seatsOpen, Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime, Timestamp time) {
		
		super();
		this.airline = airline;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.flightNumber = flightNumber;
		this.seatsOpen = seatsOpen;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.seatsOpen = seatsOpen;
		this.time = time;
		
		
	}
	
	
	public Flight(String airline, String originCity, String destinationCity, int flightNumber, int seatsOpen, Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime) {
		
		super();
		this.airline = airline;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.flightNumber = flightNumber;
		this.seatsOpen = seatsOpen;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate =arrivalDate;
		this.arrivalTime = arrivalTime;
		
	}
	
	
	public Flight(String airline, String originCity, String destinationCity, int flightNumber, Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime) {
		
		super();
		this.airline = airline;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate =arrivalDate;
		this.arrivalTime = arrivalTime;
		
	}
		
	
	
	public boolean checkIfSeatFull() {
		return checkIfSeatFull;
	}
	public void setFull(boolean checkIfSeatFull) {
		this.checkIfSeatFull = checkIfSeatFull;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getOriginCity() {
		return originCity;
	}
	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public Time getDepatureTime() {
		return departureTime;
	}
	public void setDepatureTime(Time depatureTime) {
		this.departureTime = depatureTime;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getFlightCapacity() {
		return flightCapacity;
	}
	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}
	public int getSeatsOpen() {
		return seatsOpen;
	}
	public void setSeatsOpen(int seatsOpen) {
		this.seatsOpen = seatsOpen;
	}
	public int getSeatsTaken() {
		return seatsTaken;
	}
	public void setSeatsTaken(int seatsTaken) {
		this.seatsTaken = seatsTaken;
	}
	
	@Override
	public String toString() {
		return "Flight [airline=" + airline + ", flightNumber=" + flightNumber + ", flightCapacity=" + flightCapacity
				+ ", seatsAvailable=" + seatsOpen + ", seatsOccupied=" + seatsTaken + ", originCity=" + originCity
				+ ", destinationCity=" + destinationCity + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", isFull=" + checkIfSeatFull
				+ "]";
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Object... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addListener(ListChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeAll(Object... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ListChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean retainAll(Object... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Object... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
}