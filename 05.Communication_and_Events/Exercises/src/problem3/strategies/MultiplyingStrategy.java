package problem3.strategies;

import problem3.interfaces.Strategy;

public class MultiplyingStrategy implements Strategy {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
