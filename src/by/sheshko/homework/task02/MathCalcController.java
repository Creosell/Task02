package by.sheshko.homework.task02;

import java.util.Stack;

public class MathCalcController {
    String expression;
    Stack<Integer> symbolsStack = new Stack<>();

    public MathCalcController(String expression) {
        this.expression = expression;
    }

    private static int checkSignPriority(char sign) {
        int priority = 0;

        if (sign == '*' || sign == '/') {
            priority = 3;
        } else if (sign == '+' || sign == '-') {
            priority = 2;
        } else if (sign == '(') {
            priority = 1;
        } else if (sign == ')') {
            priority = -1;
        }
        return priority;
    }


}
