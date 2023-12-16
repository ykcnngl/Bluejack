public class ExtraCard {
    private String color;
    private int extraNo;

    // Constructor ismini ExtraCard olarak değiştiriyoruz
    public ExtraCard(String color, int extraNo) {
        this.color = color;
        this.extraNo = extraNo;
    }

    public int getextraNo() {
        return extraNo;
    }

    public String getColor() {
        return color;
    }

    public String CardInformation() {
        return color + " " + extraNo;
    }
}