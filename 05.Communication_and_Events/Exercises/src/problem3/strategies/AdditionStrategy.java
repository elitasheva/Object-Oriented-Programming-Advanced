package problem3.strategies;

import problem3.interfaces.Strategy;

public class AdditionStrategy implements Strategy {

    public int calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
}
