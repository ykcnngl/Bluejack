import java.util.Random;
import java.util.Scanner;

	public class Deck {
		private String[] color = {"Yellow","Red","Green","Blue"} ;
		private String[] number = {"1","2","3","4","5","6","7","8","9","10"};
		private String[] name;
		Scanner sc=new Scanner(System.in);
		Card [] cards = new Card [40];
		Player plyr =new  Player("player");
		Computer cmptr = new Computer("computer"); 
		int dealCardindex = 0;
		
		Deck() {		// Constructor oluşturdum koddaki ilk çalışan yer buarsı
			this.suit=suit;
			this.number= number;
			this.name= name;
			int cardsIndex=0;
			
			for(int s=0;s<color.length;s++) {
				for(int n=0;n<number.length;n++) {                              // Kartları oluşturdum çarpım tablosu yapar gibi
					cards[cardsIndex]= new Card( color[s], number[n]);
					cardsIndex++;
				}
			}
		}