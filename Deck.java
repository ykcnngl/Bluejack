import java.util.Random;

public class Deck {
	Random rd = new Random(System.currentTimeMillis());
	private String[] color = {"Y","R","B","G" };   //YELLOW RED BLUE GREEN
	private int[] no = {1,2,3,4,5,6,7,8,9,10};
	private int cardNumber;
	private Card[] cards;
	public Card[] tempCards;
	
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

	public void saas() {
		tempCards = new Card[40];
		tempCards = cards;
		for(int i = 0; i<40; i++){
			int a = rd.nextInt(0,40);
			while(tempCards[a].getNo()==0){
				a = rd.nextInt(0,40);
				tempCards[a]=tempCards[a];
			}
			cards[i] = tempCards[a];
		}
		for(int i = 0; i<40; i++){
					System.out.print(cards[i].getColor()+cards[i].getNo()+" ");
				}
			}
	public Card cardShow(int no) {
		return cards[no]; 
	}

	
}
