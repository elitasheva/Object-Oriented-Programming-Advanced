package problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            ListyIterator<String> collection = null;

            while (true) {

                String input = reader.readLine();
                if ("END".equals(input)) {
                    break;
                }

                String[] params = input.split(" ");
                String command = params[0];
                try {
                    switch (command) {
                        case "Create":
                            collection = new ListyIterator<>(Arrays.asList(params).stream().skip(1).collect(Collectors.toList()));
                            break;
                        case "Move":
                            System.out.println(collection.move());
                            break;
                        case "HasNext":
                            System.out.println(collection.hasNext());
                            break;
                        case "Print":
                            System.out.println(collection.print());
                            break;
                        case "PrintAll":
                            collection.printAll();
                            break;
                        default:
                            break;
                    }
                } catch (InvalidOperationException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
