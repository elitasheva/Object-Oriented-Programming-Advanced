package problem8.models;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public String getName() {
        return this.name;
    }
}
