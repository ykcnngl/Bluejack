import java.util.Scanner;
import java.util.Random;

public class Game{
static Card[] playerDeck = new Card[4];
static Card[] computerDeck = new Card[4];
static Card[] gameDeck = new Card[30];
static Card[] playerBoard = new Card[9];
static Card[] computerBoard = new Card[9];

static int boardCounter = 0;
static int playerCounter = 0;
static int computerCounter = 0;
static int sumValueForPlayer = 0;
static int sumValueForComputer = 0;
static int sumScoreForPlayer = 0;
static int sumScoreForComputer = 0;

public static void playerUseCard() {
        System.out.println("\n**************\nKart atmak için 1 basın" + "\nKart çekmek için 2 ye basın"+"\nDurmak için 3\n****************");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while(choice<1 & choice>3){
            choice = sc.nextInt();
        }
        switch (choice) {
            case 1:                // Oyuncunun kart atma işlemi
                    System.out.println("Select a card to throw:");
                    int cardIndex = sc.nextInt();
                    while(cardIndex<0 & cardIndex>3){
                        cardIndex = sc.nextInt();
                    }
                    playerBoard[playerCounter]=playerDeck[cardIndex];
                    sumValueForPlayer+=playerDeck[cardIndex].getNo();
                    playerDeck[cardIndex]=null;
                    playerCounter++;
                    break;
                case 2:
                    // Oyuncunun kart çekme işlemi
                    playerBoard[playerCounter] = gameDeck[boardCounter];
                    sumValueForPlayer+=gameDeck[boardCounter].getNo();
                    boardCounter++;
                    playerCounter++;
                    break;
                case 3:
                    // Oyuncunun pas geçme işlemi
                    System.out.println("Player passed.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    public static void computerUseCard(){
        Random rd = new Random(System.currentTimeMillis());
        if(sumScoreForComputer<20){
            int a = rd.nextInt(0,2);
            if(a==0){
                int card = rd.nextInt(0,4);
                while(computerDeck[card]==null){
                    card = rd.nextInt(0,4);
                }
                if(sumValueForComputer+computerDeck[card].getNo()<20){
                    computerBoard[computerCounter] = computerDeck[card];
                    sumValueForComputer+= computerDeck[card].getNo();
                    computerCounter++;
                    computerDeck[card]=null;
                }

            }else{
                computerBoard[computerCounter]=gameDeck[boardCounter];
                sumValueForComputer+=gameDeck[boardCounter].getNo();
                computerCounter++;
                boardCounter++;

            }
        }else System.out.println("PC KART ATMIYOR");
    }
    public static void printCards(){
        System.out.println("\n************\nPlayer Deck\t\t\t\tPlayer Score = " + sumValueForPlayer);
        for(int i=0; i<4; i++){
            if(playerDeck[i]==null) System.out.print(" ");
            else System.out.print(playerDeck[i].getColor()+playerDeck[i].getNo()+" ");
        }System.out.print("\n************\nPlayer Board\n");
        for(int i=0; i<9; i++){
            if(playerBoard[i]==null) System.out.print(" ");
            else System.out.print(playerBoard[i].getColor()+playerBoard[i].getNo()+" ");
        }System.out.println("\n************\nComputer Deck\t\t\t\tComputer Score = " + sumValueForComputer);
        for(int i=0; i<4; i++){
            if(computerDeck[i]==null) System.out.print(" ");
            else System.out.print(computerDeck[i].getColor()+computerDeck[i].getNo()+" ");
        }System.out.print("\n************\nComputer Board\n");
        for(int i=0; i<9; i++){
            if(computerBoard[i]==null) System.out.print(" ");
            else System.out.print(computerBoard[i].getColor()+computerBoard[i].getNo()+" ");
        }
        
    }


public static void main(String[] args) {
    Deck deck = new Deck();
    deck.print();
    deck.Shuffle();
    deck.dealPlayerCard();
    deck.dealComputerCard();
    deck.generateRandomCardForPlayer();
    deck.generateRandomCardForComputer();
    deck.SelectCardForPlayer();
    deck.SelectCardForComputer();
    deck.printDeck();
    playerDeck = deck.GamePlayerDeck;
    computerDeck = deck.GameComputerDeck;
    gameDeck = deck.gameDeck;
    System.out.println();
    /*for(int i=0; i<30; i++){
        System.out.print(gameDeck[i].getColor()+gameDeck[i].getNo()+" ");
        }*/
    printCards();
    while(sumScoreForComputer<3 & sumScoreForPlayer<3){
        playerUseCard();
        computerUseCard();
        printCards();
    }
    }
}
