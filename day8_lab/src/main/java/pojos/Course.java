package pojos;

public enum Course {

	DAC(110000),DITID(85000),DBDA(85000),AI(125000),DMC(90000);
	private int price;
	private Course(int price)
	{
		this.price=price;
		
	}
}
