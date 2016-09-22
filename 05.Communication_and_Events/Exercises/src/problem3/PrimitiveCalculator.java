package problem3;


import problem3.interfaces.Strategy;
import problem3.strategies.AdditionStrategy;

public class PrimitiveCalculator {

    private Strategy strategy;

    public PrimitiveCalculator() {
        this.strategy = new AdditionStrategy();
    }

    public void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int performCalculation(int firstOperand, int secondOperand) {
        return strategy.calculate(firstOperand, secondOperand);
    }
}
