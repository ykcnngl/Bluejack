public class Game {

    public static void main(String[] args) {
        Deck d1 = new Deck();
        //array aç card
        //burada açtığına arrayi card
        System.out.println("BEFORE SHUFFLE");
        for (int k = 0; k < 40; k++) {
            System.out.print(d1.cardShow(k).getColor() + d1.cardShow(k).getNo() + " ");
        }
        System.out.println();
        System.out.println("AFTER SHUFFLE");
        d1.Shuffle();
		
		System.out.println("");
		System.out.println("");
        d1.dealPlayerCard();
        System.out.println();
        d1.dealComputerCard();
        System.out.println();
        d1.generateRandomCardForPlayer();
        d1.generateRandomCardForComputer();
        d1.SelectCardForPlayer();
        d1.SelectCardForComputer();

    }
}
