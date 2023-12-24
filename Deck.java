import java.util.Random;

public class Deck {
	Random rd = new Random(System.currentTimeMillis());
	private String[] color = {"Y","R","B","G" };   //YELLOW RED BLUE GREEN
	private int[] no = {1,2,3,4,5,6,7,8,9,10};
	private Card[] cards;
	private Card[] randomCards = new Card[5];
	private Card[] playerdeck = new Card[10];
	public Card[] computerdeck = new Card[10];
	public Card[] gameDeck = new Card[30];
	public Card[] GamePlayerDeck = new Card[4];
	public Card[] GameComputerDeck = new Card[4];

	
	public Deck() {                                                // Cards are created.
		cards = new Card[40];
		int cardNumber = 0 ;
		for(int c = 0; c < color.length; c++) {
			for (int n = 0; n < no.length; n++ ) {
				cards[cardNumber]= new Card(color[c], no[n]) ;
				cardNumber ++;
			}
		} 
	}

	public void print(){                                            //Cards print to screen.
		System.out.println("\nBefore Shuffle Deck");
		for(int i = 0; i <40; i++) {
			System.out.print(cards[i].getColor()+cards[i].getNo()+ " ");
		}
	}
	public void Shuffle() {                                           // Cards shuffled.
        Random rd = new Random();

        for (int i = 39; i > 0; i--) {
            int j = rd.nextInt(i + 1);

            // Swap işlemi
            Card temp = cards[i];                                    // The cards were shuffled by assigning a temporary sequence.
            cards[i] = cards[j];
            cards[j] = temp;
        }
		System.out.println("\nAfter shuffle deck");                // Mixed deck was printed.
        for (int i = 0; i < 40; i++) {
            System.out.print(cards[i].getColor() + cards[i].getNo() + " ");
        }
    }




	public void dealPlayerCard(){                                          // We give 5 cards from the deck to the deck in the player's hand.
		//System.out.println("\nPlayer Cards");
		int index=39;
		for (int i = 0; i < 5; i++) {
            playerdeck[i] = cards[index];
			index--;
        }
	/*for (int i = 0; i < 5; i++) {
			System.out.print(playerdeck[i].getColor() + playerdeck[i].getNo() + " ");
	}*/
	}
	public void dealComputerCard(){                                          // We give 5 cards from the deck to the deck in the computer's hand.
		//System.out.println("\nPc Cards");
		for (int i = 0; i < 5; i++) {
            computerdeck[i] = cards[i];
        }
	/*for (int i = 0; i < 5; i++) {
			System.out.print(computerdeck[i].getColor() + computerdeck[i].getNo() + " ");
	}*/
	}
	public void generateRandomCardForPlayer(){
		//System.out.println("*************\nRANDOM CARDS");
		int[] percent = new int[101];
		for(int i = 1; i<101; i++){
			percent[i] = i;
		}
		int b = 0; //I will keep this as a control variable, after it becomes 3, it will enter the last 2 cards
		for(int i=0; i<3; i++){	//here we need to write the first 3 card distributions
			int c = rd.nextInt(0,4); //Random one of 4 colors will arrive
			int a = rd.nextInt(1,7); // SELECTS WHICH CARDS WILL BE BETWEEN 1 AND 6
			int d = rd.nextInt(0,2); // SELECTS WHETHER THE CARDS WILL BE + OR -
			if(d==0) a*=-1;                       
			else a*=1;
			randomCards[i] = new Card(color[c], a);
			b++;
		}
		if(b>=3){
			for(int n = 3; n<5; n++){
				int control1 =rd.nextInt(1,101); // Creates 80% chance
				if(control1<=80){ //If the 80 is lucky, we will proceed from this part.
					int c = rd.nextInt(0,4); //Random one of 4 colors will arrive
					int a = rd.nextInt(1,7); // SELECTS WHICH CARDS WILL BE BETWEEN 1 AND 6
					int d = rd.nextInt(0,2); // SELECTS WHETHER THE CARDS WILL BE + OR -
					if(d==0) a*=-1;
					else a*=1;
					randomCards[n] = new Card(color[c], a);
				}else { // this will correspond to the 20% part
					int e = rd.nextInt(0,2);
					if(e==0){ // flip if equal to 0
						randomCards[n] = new Card("FLIP X", -1);
					}
					else{	// double if equal to 1
						randomCards[n] = new Card("DOUBLE X", 2);
					}
				}
		}
	}
	/*for(int i=0; i<5; i++){	//here we need to write the first 3 card distributions
		System.out.print(randomCards[i].getColor()+randomCards[i].getNo() + " ");
	}*/
	//System.out.println();
	int writeplayer=5;
	for(int i=0; i<5; i++){	//here we need to write the first 3 card distributions
		playerdeck[writeplayer]=randomCards[i];
		writeplayer++;
	}
	/*System.out.println("WITH THE PLAYER'S FIRST 5 CARDS AND RANDOM CARDS");
	for (int i = 0; i<10; i++) {
			System.out.print(playerdeck[i].getColor() + playerdeck[i].getNo() + ",");
	}*/
}
public void generateRandomCardForComputer(){
		//System.out.println("\n******************\nRANDOM CARDS");
		int[] percent = new int[101];
		for(int i = 1; i<101; i++){
			percent[i] = i;
		}
		int b = 0; //I will keep this as a control variable, after it becomes 3, it will enter the last 2 cards
		for(int i=0; i<3; i++){	//here we need to write the first 3 card distributions
			int c = rd.nextInt(0,4); //Random one of 4 colors will arrive
			int a = rd.nextInt(1,7); //SELECTS WHICH CARDS WILL BE BETWEEN 1 AND 6
			int d = rd.nextInt(0,2); // SELECTS WHETHER THE CARDS WILL BE + OR -
			if(d==0) a*=-1;
			else a*=1;
			randomCards[i] = new Card(color[c], a);
			b++;
		}
		if(b>=3){
			for(int n = 3; n<5; n++){
				int control1 =rd.nextInt(1,101); // Creates 80% chance
				if(control1<=80){ //If the 80 is lucky, we will proceed from this part.
					int c = rd.nextInt(0,4); //Random one of 4 colors will arrive
					int a = rd.nextInt(1,7); // SELECTS WHICH CARDS WILL BE BETWEEN 1 AND 6
					int d = rd.nextInt(0,2); // SELECTS WHETHER THE CARDS WILL BE + OR -
					if(d==0) a*=-1;
					else a*=1;
					randomCards[n] = new Card(color[c], a);
				}else { // This will correspond to the 20% part
					int e = rd.nextInt(0,2);
					if(e==0){ // flip if equal to 0
						randomCards[n] = new Card("FLIP X", -1);
					}
					else{	// double if equal to 1
						randomCards[n] = new Card("DOUBLE X", 2);
					}
				}
		}
	}
	/*for(int i=0; i<5; i++){	
		System.out.print(randomCards[i].getColor()+randomCards[i].getNo() + " ");
	}*/
	//System.out.println();
	int writeplayer=5;
	for(int i=0; i<5; i++){	//here we need to write the first 3 card distributions
		computerdeck[writeplayer]=randomCards[i];
		writeplayer++;
	}
	/*System.out.println("WITH THE COMPUTER'S FIRST 5 CARDS AND RANDOM CARDS");
	for (int i = 0; i<10; i++) {
			System.out.print(computerdeck[i].getColor() + computerdeck[i].getNo() + ",");
	}*/
}

public void SelectCardForPlayer(){
	//System.out.println("\n***************\nPLAYER GAME DECK");
	int[] control = new int[11];
	for(int i=1; i<11 ; i++){
		control[i]=i;
	}
	for(int i=0; i<4 ; i++){
		int a = rd.nextInt(1,10);
		while(control[a]==-1){
			a = rd.nextInt(1,10);
		}
		GamePlayerDeck[i] = playerdeck[a];
		control[a] = -1;
	}/*for (int i = 0; i<4; i++) {
			System.out.print(GamePlayerDeck[i].getColor() + GamePlayerDeck[i].getNo() + ",");
	}*/
}
public void SelectCardForComputer(){
	//System.out.println("\nCOMPUTER GAME DECK");
	int[] control = new int[11];
	for(int i=1; i<11 ; i++){
		control[i]=i;
	}
	for(int i=0; i<4 ; i++){
		int a = rd.nextInt(1,10);
		while(control[a]==-1){
			a = rd.nextInt(1,10);
		}
		GameComputerDeck[i] = computerdeck[a];
		control[a] = -1;
	 }/*for (int i = 0; i<4; i++) {
			System.out.print(GameComputerDeck[i].getColor() + GameComputerDeck[i].getNo() + ",");
	}*/
}
public void printDeck(){
	int index = 5;
	for(int i=0; i<30; i++){
		gameDeck[i]=new Card(cards[index].getColor(),cards[index].getNo());
		index++;
	}
}
public Card cardShow(int no) {
        return cards[no];
    }
}