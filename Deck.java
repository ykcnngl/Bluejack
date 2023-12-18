import java.util.Random;

import javax.sound.sampled.SourceDataLine;

public class Deck {
	Random rd = new Random(System.currentTimeMillis());
	private String[] color = {"Y","R","B","G" };   //YELLOW RED BLUE GREEN
	private int[] no = {1,2,3,4,5,6,7,8,9,10};
	private int cardNumber;
	private Card[] cards;
	public Card[] tempCards;
	public Card[] randomCards = new Card[5];
	public Card[] playerdeck = new Card[10];
	public Card[] computerdeck = new Card[10];

	public Card[] GamePlayerDeck = new Card[4];
	public Card[] GameComputerDeck = new Card[4];

	
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

	public void Shuffle() {
        Random rd = new Random();

        for (int i = 39; i > 0; i--) {
            int j = rd.nextInt(i + 1);

            // Swap işlemi
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }

        for (int i = 0; i < 40; i++) {
            System.out.print(cards[i].getColor() + cards[i].getNo() + " ");
        }
    }




	public void dealPlayerCard(){
		System.out.println("oyuncu kartları");
		int idx=39;
		for (int i = 0; i < 5; i++) {
            playerdeck[i] = cards[idx];
			idx--;
        }
	for (int i = 0; i < 5; i++) {
			System.out.print(playerdeck[i].getColor() + playerdeck[i].getNo() + " ");
	}
	}
	public void dealComputerCard(){
		System.out.println("pc kartları");
		for (int i = 0; i < 5; i++) {
            computerdeck[i] = cards[i];
        }
	for (int i = 0; i < 5; i++) {
			System.out.print(computerdeck[i].getColor() + computerdeck[i].getNo() + " ");
	}
	}
	public void generateRandomCardForPlayer(){
		System.out.println("*************\nRANDOM CARDS");
		int[] percent = new int[101];
		for(int i = 1; i<101; i++){
			percent[i] = i;
		}
		int b = 0; //bunu kontrol değişkeni olarak tutucam 3 olduktan sonra son 2 karta girecek
		for(int i=0; i<3; i++){	//burada ilk 3 kart dağıtımı yazmamız gerekiyor
			int c = rd.nextInt(0,4); //random 4 rengten bir tanesi gelecek
			int a = rd.nextInt(1,7); // KARTLARIN 1 İLE 6 ARASINDA HANGİSİ OLACAĞINI SEÇİYOR
			int d = rd.nextInt(0,2); // KARTLARIN + MI - Mİ OLACAĞINI SEÇİYOR
			if(d==0) a*=-1;
			else a*=1;
			randomCards[i] = new Card(color[c], a);
			b++;
		}
		if(b>=3){
			for(int n = 3; n<5; n++){
				int control1 =rd.nextInt(1,101); // %80 şans yaratır
				if(control1<=80){ //80 lik şansa gelirse buraya gelecek
					int c = rd.nextInt(0,4); //random 4 rengten bir tanesi gelecek
					int a = rd.nextInt(1,7); // KARTLARIN 1 İLE 6 ARASINDA HANGİSİ OLACAĞINI SEÇİYOR
					int d = rd.nextInt(0,2); // KARTLARIN + MI - Mİ OLACAĞINI SEÇİYOR
					if(d==0) a*=-1;
					else a*=1;
					randomCards[n] = new Card(color[c], a);
				}else { // burası %20 lik kısıma denk gelecek
					int e = rd.nextInt(0,2);
					if(e==0){ // 0 eşitse flip
						randomCards[n] = new Card("FLIP X", -1);
					}
					else{	// 1 eşitse double
						randomCards[n] = new Card("DOUBLE X", 2);
					}
				}
		}
	}
	for(int i=0; i<5; i++){	//burada ilk 3 kart dağıtımı yazmamız gerekiyor
		System.out.print(randomCards[i].getColor()+randomCards[i].getNo() + " ");
	}
	System.out.println();
	int writeplayer=5;
	for(int i=0; i<5; i++){	//burada ilk 3 kart dağıtımı yazmamız gerekiyor
		playerdeck[writeplayer]=randomCards[i];
		writeplayer++;
	}
	System.out.println("OYUNCUNUN İLK 5 KART VE RANDOM KARTLARI İLE BİRLİKTE");
	for (int i = 0; i<10; i++) {
			System.out.print(playerdeck[i].getColor() + playerdeck[i].getNo() + ",");
	}
}
public void generateRandomCardForComputer(){
		System.out.println("\n******************\nRANDOM CARDS");
		int[] percent = new int[101];
		for(int i = 1; i<101; i++){
			percent[i] = i;
		}
		int b = 0; //bunu kontrol değişkeni olarak tutucam 3 olduktan sonra son 2 karta girecek
		for(int i=0; i<3; i++){	//burada ilk 3 kart dağıtımı yazmamız gerekiyor
			int c = rd.nextInt(0,4); //random 4 rengten bir tanesi gelecek
			int a = rd.nextInt(1,7); // KARTLARIN 1 İLE 6 ARASINDA HANGİSİ OLACAĞINI SEÇİYOR
			int d = rd.nextInt(0,2); // KARTLARIN + MI - Mİ OLACAĞINI SEÇİYOR
			if(d==0) a*=-1;
			else a*=1;
			randomCards[i] = new Card(color[c], a);
			b++;
		}
		if(b>=3){
			for(int n = 3; n<5; n++){
				int control1 =rd.nextInt(1,101); // %80 şans yaratır
				if(control1<=80){ //80 lik şansa gelirse buraya gelecek
					int c = rd.nextInt(0,4); //random 4 rengten bir tanesi gelecek
					int a = rd.nextInt(1,7); // KARTLARIN 1 İLE 6 ARASINDA HANGİSİ OLACAĞINI SEÇİYOR
					int d = rd.nextInt(0,2); // KARTLARIN + MI - Mİ OLACAĞINI SEÇİYOR
					if(d==0) a*=-1;
					else a*=1;
					randomCards[n] = new Card(color[c], a);
				}else { // burası %20 lik kısıma denk gelecek
					int e = rd.nextInt(0,2);
					if(e==0){ // 0 eşitse flip
						randomCards[n] = new Card("FLIP X", -1);
					}
					else{	// 1 eşitse double
						randomCards[n] = new Card("DOUBLE X", 2);
					}
				}
		}
	}
	for(int i=0; i<5; i++){	//burada ilk 3 kart dağıtımı yazmamız gerekiyor
		System.out.print(randomCards[i].getColor()+randomCards[i].getNo() + " ");
	}
	System.out.println();
	int writeplayer=5;
	for(int i=0; i<5; i++){	//burada ilk 3 kart dağıtımı yazmamız gerekiyor
		computerdeck[writeplayer]=randomCards[i];
		writeplayer++;
	}
	System.out.println("PC İLK 5 KART VE RANDOM KARTLARI İLE BİRLİKTE");
	for (int i = 0; i<10; i++) {
			System.out.print(computerdeck[i].getColor() + computerdeck[i].getNo() + ",");
	}
}

public void SelectCardForPlayer(){
	System.out.println("\n***************\nPLAYER GAME DECK");
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
	}for (int i = 0; i<4; i++) {
			System.out.print(GamePlayerDeck[i].getColor() + GamePlayerDeck[i].getNo() + ",");
	}
}
public void SelectCardForComputer(){
	System.out.println("\nCOMPUTER GAME DECK");
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
	}for (int i = 0; i<4; i++) {
			System.out.print(GameComputerDeck[i].getColor() + GameComputerDeck[i].getNo() + ",");
	}
}



































    public Card cardShow(int no) {
        return cards[no];
    }
	
	
	


	



}
