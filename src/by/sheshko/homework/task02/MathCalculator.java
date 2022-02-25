package by.sheshko.homework.task02;

public class MathCalculator {

    public double calculateExpression(final String expression) {
        MathCalcLogic logic = new MathCalcLogic();
        ExpressionToRPN rpn = new ExpressionToRPN();

        return logic.calculateRPN(rpn.convertToRPN(expression));
    }
}