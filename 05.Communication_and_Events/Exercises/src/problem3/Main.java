package problem3;

import problem3.interfaces.Strategy;
import problem3.strategies.AdditionStrategy;
import problem3.strategies.DividingStrategy;
import problem3.strategies.MultiplyingStrategy;
import problem3.strategies.SubtractionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            PrimitiveCalculator calculator = new PrimitiveCalculator();
            while (true) {
                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }

                String[] params = input.split("[\\s]+");

                if (!params[0].equals("mode")) {
                    int firstOperand = Integer.parseInt(params[0]);
                    int secondOperand = Integer.parseInt(params[1]);
                    int result = calculator.performCalculation(firstOperand, secondOperand);
                    System.out.println(result);
                } else {
                    String operator = params[1];
                    Strategy strategy = null;
                    switch (operator) {
                        case "+":
                            strategy = new AdditionStrategy();
                            break;
                        case "-":
                            strategy = new SubtractionStrategy();
                            break;
                        case "*":
                            strategy = new MultiplyingStrategy();
                            break;
                        case "/":
                            strategy = new DividingStrategy();
                            break;
                    }
                    calculator.changeStrategy(strategy);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
