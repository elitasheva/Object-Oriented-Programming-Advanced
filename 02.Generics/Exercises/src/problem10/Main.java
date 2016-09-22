package problem10;

import problem10.intefaces.Tuple;
import problem10.models.TupleImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input1 = reader.readLine().split(" ");
            String name1 = input1[0] + " " + input1[1];
            String address = input1[2];
            Tuple<String, String> tuple1 = new TupleImpl(name1, address);
            System.out.println(tuple1.toString());

            String[] input2 = reader.readLine().split(" ");
            String name2 = input2[0];
            Integer beers = Integer.parseInt(input2[1]);
            Tuple<String, Integer> tuple2 = new TupleImpl<>(name2, beers);
            System.out.println(tuple2.toString());

            String[] input3 = reader.readLine().split(" ");
            Integer numberInt = Integer.parseInt(input3[0]);
            Double numberDouble = Double.parseDouble(input3[1]);
            Tuple<Integer, Double> tuple3 = new TupleImpl<>(numberInt, numberDouble);
            System.out.println(tuple3.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
