package problem11;

import problem11.interfaces.Triplet;
import problem11.models.TripletImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input1 = reader.readLine().split(" ");
            String name1 = input1[0] + " " + input1[1];
            String address = input1[2];
            String town = input1[3];
            Triplet<String, String, String> triplet1 = new TripletImpl(name1, address, town);
            System.out.println(triplet1.toString());

            String[] input2 = reader.readLine().split(" ");
            String name2 = input2[0];
            Integer beers = Integer.parseInt(input2[1]);
            Boolean hasDrinken = input2[2].contains("not") ? false : true;
            Triplet<String, Integer, Boolean> triplet2 = new TripletImpl<>(name2, beers, hasDrinken);
            System.out.println(triplet2.toString());

            String[] input3 = reader.readLine().split(" ");
            String name3 = input3[0];
            Double balance = Double.parseDouble(input3[1]);
            String bankName = input3[2];
            Triplet<String, Double, String> triplet3 = new TripletImpl<>(name3,balance,bankName);
            System.out.println(triplet3.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
