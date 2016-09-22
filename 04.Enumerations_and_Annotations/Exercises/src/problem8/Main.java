package problem8;

import problem8.enums.Rank;
import problem8.enums.Suit;
import problem8.models.Card;
import problem8.models.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            HashMap<String,Card> cardsByName = new LinkedHashMap<>();
            String nameFirstPlayer = reader.readLine();
            String nameSecondPlayer = reader.readLine();

            Player firstPlayer = new Player(nameFirstPlayer);
            Player secondPlayer = new Player(nameSecondPlayer);
            int count = 0;
            while (count < 10){
                String currentCardName = reader.readLine();
                String[] paramsForCheck = currentCardName.split("of");
                String rank = paramsForCheck[0].trim();
                String suit = paramsForCheck[1].trim();

                Rank r = null;
                Suit s = null;
                try {
                    r = Rank.valueOf(rank);
                    s = Suit.valueOf(suit);

                }catch (IllegalArgumentException ex){
                    System.out.println("No such card exists.");
                    continue;
                }

                int power = r.getPower()+s.getPower();
                Card currentCard = new Card(currentCardName, power);
                if (cardsByName.containsKey(currentCardName)){
                    System.out.println("Card is not in the deck.");
                    continue;
                }

                cardsByName.put(currentCardName, currentCard);

                if (count < 5){
                    firstPlayer.getCards().add(currentCard);
                }else {
                    secondPlayer.getCards().add(currentCard);
                }

                count++;
            }

            Collections.sort(firstPlayer.getCards());
            Collections.sort(secondPlayer.getCards());

            Player winner = null;
            if (firstPlayer.getCards().get(4).compareTo(secondPlayer.getCards().get(4)) > 0){
                winner = firstPlayer;
            }else {
                winner = secondPlayer;
            }

            System.out.printf("%s wins with %s.", winner.getName(), winner.getCards().get(4).toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
