package by.sheshko.homework.task02;

/**
 * Класс MathCalculator является основным в библиотеке и используется
 * для взаимодействия всех составляющих библиотеку классов.
 */
public class MathCalculator {

    public static void main(final String[] args) {
    }

    public double calculateExpression(final String expression) {
        MathCalculatorLogic logic = new MathCalculatorLogic();
        ExpressionToReversePolishNotation rpn = new ExpressionToReversePolishNotation();

        return logic.calculateRPN(rpn.convertToRPN(expression));
    }
}
