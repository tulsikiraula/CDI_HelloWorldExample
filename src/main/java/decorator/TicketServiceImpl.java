package decorator;

public class TicketServiceImpl  implements TicketService{

	Ticket ticket;
	
	public Ticket book(String ticketname) {
		return ticket = new Ticket("20-july","21-july",ticketname);
	}

}
