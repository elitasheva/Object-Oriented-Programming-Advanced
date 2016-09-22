package problem1;

import problem1.models.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Box<? extends Comparable<Double>>> list = new ArrayList<>();
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {

                Box<Double> box = new Box(Double.valueOf(reader.readLine()));
                Box<String> box2 = new Box("fgdffgh");
                list.add(box);
                //list.add(box2);
            }

//            int[] indices = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
//            swap(list, indices);
//
//            for (Box box : list) {
//                System.out.println(box.toString());
//            }


            Box<Double> valueToCompare = new Box(Double.valueOf(reader.readLine()));
            int countCompare = count(list, valueToCompare);
            System.out.println(countCompare);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> int count(List<Box<? extends Comparable<T>>> list, Box valueToCompare) {

        int count = 0;
        for (Box box : list) {
            if (box.getValue().compareTo(valueToCompare.getValue()) > 0) {
                count++;
            }
        }
        return count;
    }

    private static void swap(List<Box> list, int[] indices) {

        int firstIndex = indices[0];
        int secondIndex = indices[1];
        Box temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);

    }
}
