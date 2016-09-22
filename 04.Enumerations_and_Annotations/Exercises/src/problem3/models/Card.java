package problem3.models;

public class Card implements Comparable<Card> {

    private String cardName;
    private int cardPower;

    public Card(String cardName, int cardPower) {
        this.cardName = cardName;
        this.cardPower = cardPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s; Card power: %d%n", this.cardName, this.cardPower);
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.cardPower, other.cardPower);
    }
}
