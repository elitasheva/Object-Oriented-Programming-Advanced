package problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StackIteratorImpl<Integer> stack;

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            stack = new StackIteratorImpl<>();
            while (true) {
                String input = reader.readLine();
                if ("END".equals(input)) {
                    break;
                }

                String[] params = input.split(" ");
                String command = params[0];
                try {
                    switch (command) {
                        case "Push":
                            pushElementToStack(params);
                            break;
                        case "Pop":
                            stack.pop();
                            break;
                        default:
                            System.out.println("Unknown command!");
                            break;
                    }
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

            }
            for (Integer integer : stack) {
                System.out.println(integer);
            }
            for (Integer integer : stack) {
                System.out.println(integer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pushElementToStack(String[] params) {
        for (int i = 1; i < params.length; i++) {
            String currentStr = params[i].replace(',', ' ');
            Integer current = Integer.parseInt(currentStr.trim());
            stack.push(current);
        }
    }
}
