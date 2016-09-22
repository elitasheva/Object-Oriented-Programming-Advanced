package problem8.models;

public class Card implements Comparable<Card> {

    private String cardName;
    private int cardPower;

    public Card(String cardName, int cardPower) {
        this.cardName = cardName;
        this.cardPower = cardPower;
    }

    @Override
    public String toString() {

        return this.cardName;
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.cardPower, other.cardPower);
    }
}