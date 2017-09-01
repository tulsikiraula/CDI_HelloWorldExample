/*package decorator;

import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@javax.decorator.Decorator
public class Decorator implements TicketService{
	
	@Delegate
	@Inject
	TicketService ticket;
	
	@Inject
	CateringService cater;
	
	Ticket t;
	public Ticket book(String ticket1) {
		//t=new Ticket("20-july","21-july");
		t=ticket.book("train ticket");
		cater.cater(t);
		return t;
	}

}
*/