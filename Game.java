public class Game {

    public static void main(String[] args) {
        Deck d1 = new Deck();
        for (int k = 0; k < 40; k++) {
            System.out.print(d1.cardShow(k).getColor() + d1.cardShow(k).getNo() + " ");
        }
        System.out.println();
        System.out.println("AFTER SHUFFLE");
        d1.Shuffle();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Extra Deck");
		System.out.println("");

        ExtraDeck d2 = new ExtraDeck();  // ExtraDeck sınıfını doğrudan kullanıyoruz
        for (int k = 0; k < 48; k++) {
            System.out.print(d2.extracardShow(k).getColor() + d2.extracardShow(k).getextraNo() + " ");
        }
        System.out.println();
        System.out.println("AFTER SHUFFLE");
        d2.Shuffle();
    }
}
