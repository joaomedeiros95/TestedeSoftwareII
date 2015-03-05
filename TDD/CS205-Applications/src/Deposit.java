
public class Deposit {

	String date = "Undefined";
	int pennies = -1;
	
	public Deposit(String date, int pennies) {
		this.date = date;
		this.pennies = pennies;
	}

	public int amount() {
		return pennies;
	}

	public String date() {
		return date;
	}

}
