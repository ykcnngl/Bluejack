
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		Random rd = new Random(System.currentTimeMillis());
		Deck d1 = new Deck();
		for (int k = 0; k < 40; k++) {
			System.out.print(d1.cardShow(k).getColor() + d1.cardShow(k).getNo()+ " ");
		}
		System.out.println();
		System.out.println("AFTER SHUFFLE");
		d1.Shuffle();
	}

}