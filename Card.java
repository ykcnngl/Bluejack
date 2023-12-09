public class Card{
	
	private String color;
	private String no;
	
	public Card(String color, String no) {
		this.color=color;
		this.no=no;
	}
	
	public String getNo() {
		return no;
	}
	
	public String setNo() {
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