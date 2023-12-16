public class Card{
	
	private String color;
	private int no;
	

	public Card(String color, int no) {
		this.color=color;
		this.no=no;
	}
	
	public int getNo() {
		return no;
	}
	
	public int setNo() {
		return no;
	}
	
	public String getColor() {
		return color;
	}
	
	public String setColor() {
		return color;
	}
	
	public String CardInformation() {
		return color + " " + no;
	}
	
}

