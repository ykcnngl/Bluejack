import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Deck d1 = new Deck();
        Scanner scanner = new Scanner(System.in);
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

        int playerTotalSum = 0;
        int computerTotalSum = 0;

        // Oyunun devamını buraya ekleyebilirsiniz.
        while (true) {
            // Oyuncunun kart atması
            System.out.println("\nPlayer's turn: ");
            System.out.println("Select a card to play (enter the number 1-4): ");
            int playerCardNumber = scanner.nextInt();
            int playerCardValue = d1.playPlayerCard(playerCardNumber);
            playerTotalSum += playerCardValue;
            System.out.println("Player Total Sum: " + playerTotalSum);

            // Oyuncuya rastgele kart ver ve attığı kartı kendi desteğinden sil
            d1.giveRandomCardToPlayer();
            d1.removePlayedCardFromPlayerDeck(playerCardNumber);

            // Attıktan sonra çekilen kartı playergamedeck'e ekle
            d1.addToPlayerGameDeck();

            // Sıra bilgisayara geçtiğinde elindeki kartları göster
            System.out.println("\nYour hand: ");
            d1.showPlayerGameDeck();

            if (playerTotalSum == 20) {
                System.out.println("Player wins!");
                break;
            } 

            // Bilgisayarın kart atması
            System.out.println("\nComputer's turn: ");
            int computerCardValue = d1.computerPlay();
            computerTotalSum += computerCardValue;
            System.out.println("Computer Total Sum: " + computerTotalSum);

            // Bilgisayara rastgele kart ver ve attığı kartı kendi desteğinden sil
            d1.giveRandomCardToComputer();
            d1.removePlayedCardFromComputerDeck();

            if (computerTotalSum == 20) {
                System.out.println("Computer wins!");
                break;
            } 
        }

       

    }
}
