package decorator;

public class CateringServiceImpl  implements CateringService{

	public String cater(Ticket ticket) {
		return ticket + "food";
	}

}
