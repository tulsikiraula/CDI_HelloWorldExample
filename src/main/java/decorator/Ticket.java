package decorator;

public class Ticket {
	
	String bookingDate;
	String jorneyDate;
	String ticket;
	
	public Ticket(String bookingDate, String jorneyDate, String ticket) {
		super();
		this.bookingDate = bookingDate;
		this.jorneyDate = jorneyDate;
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Ticket [bookingDate=" + bookingDate + ", jorneyDate=" + jorneyDate + "]";
	}

	
}
