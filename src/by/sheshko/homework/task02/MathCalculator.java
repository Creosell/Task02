package by.sheshko.homework.task02;

public class MathCalculator {

    public static void main(final String[] args) {
        MathCalculator calculator = new MathCalculator();

        System.out.println(calculator.calculateExpression("2/03)*(200)+1"));
    }

    public double calculateExpression(final String expression) {
        MathCalcLogic logic = new MathCalcLogic();
        ExpressionToRPN rpn = new ExpressionToRPN();

        return logic.calculateRPN(rpn.convertToRPN(expression));
    }
}
