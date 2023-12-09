public class Deck {
	private String[] color = {"Y","R","B","G" };   //YELLOW RED BLUE GREEN
	private String[] no = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private int cardNumber;
	private Card[] cards;
	
	public Deck() {
		cards = new Card[40];
		cardNumber = 0 ;
		for(int c = 0; c < color.length; c++) {
			for (int n = 0; n < no.length; n++ ) {
				cards[cardNumber]= new Card(color[c], no[n]) ; 
				cardNumber ++;
			}
		} 
	}
	public Card cardShow(int no) {
		return cards[no]; 
	}
}
