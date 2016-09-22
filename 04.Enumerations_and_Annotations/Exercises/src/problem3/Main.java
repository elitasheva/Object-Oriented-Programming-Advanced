package problem3;

import problem3.annotations.CustomAnnotation;
import problem3.enums.Rank;
import problem3.enums.Suit;
import problem3.models.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

//            String rank1 = reader.readLine();
//            String suit1 = reader.readLine();
//            int powerOfRank1 = Rank.valueOf(rank1).getPower();
//            int powerOfSuit1 = Suit.valueOf(suit1).getPower();
//
//            String cardName1 = rank1 + " of " + suit1;
//            int cardPower1 = powerOfRank1 + powerOfSuit1;
//
//            Card card1 = new Card(cardName1, cardPower1);
//
//            String rank2 = reader.readLine();
//            String suit2 = reader.readLine();
//            int powerOfRank2 = Rank.valueOf(rank2).getPower();
//            int powerOfSuit2 = Suit.valueOf(suit2).getPower();
//
//            String cardName2 = rank2 + " of " + suit2;
//            int cardPower2 = powerOfRank2 + powerOfSuit2;
//
//            Card card2 = new Card(cardName2, cardPower2);
//
//            if (card1.compareTo(card2) > 0){
//                System.out.println(card1);
//            }else {
//                System.out.println(card2);
//            }

            String input = reader.readLine();
            String path = Rank.class.getPackage().getName();
            Class currentClas = Class.forName(path + "." + input);
            Annotation current = currentClas.getAnnotation(CustomAnnotation.class);
            if (current instanceof CustomAnnotation){
                CustomAnnotation customAnnotation = (CustomAnnotation) current;
                System.out.printf("Type = %s, Description = %s",
                        customAnnotation.type(), customAnnotation.description());
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
