import java.util.Random;

public class ExtraDeck  {
    private String[] color = {"Y", "R", "B", "G"}; // YELLOW RED BLUE GREEN
    private int[] extraNo = {-6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6};
    private int extracardNumber;
    private ExtraCard[] extraCards;

    public ExtraDeck() {
        extraCards = new ExtraCard[48];  // 4 renk * 12 numara ek kart
        extracardNumber = 0;
        for (int c = 0; c < color.length; c++) {
            for (int n = 0; n < extraNo.length; n++) {
                extraCards[extracardNumber] = new ExtraCard(color[c], extraNo[n]);
                extracardNumber++;
            }
        }
    }

    public void Shuffle() {
        Random rd = new Random();

        for (int i = 47; i > 0; i--) {
            int j = rd.nextInt(i + 1);

            // Swap işlemi
            ExtraCard temp = extraCards[i];
            extraCards[i] = extraCards[j];
            extraCards[j] = temp;
        }

        for (int i = 0; i < 48; i++) {
            System.out.print(extraCards[i].getColor() + extraCards[i].getextraNo() + " ");
        }

    }
    public ExtraCard extracardShow(int extraNo) {
        return extraCards[extraNo];
    }          

}