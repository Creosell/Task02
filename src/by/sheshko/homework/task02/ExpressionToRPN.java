package by.sheshko.homework.task02;

import java.util.Stack;

public class ExpressionToRPN {

    private static int checkSignPriority(final char sign) {
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

    public String convertToRPN(final String expression) {
        String formattedExpression = expression.trim();
        StringBuilder builder = new StringBuilder();
        Stack<Character> symbolsStack = new Stack<>();

        for (int i = 0; i < formattedExpression.length(); i++) {
            char currentChar = formattedExpression.charAt(i);
            int currentPriority = checkSignPriority(currentChar);

            switch (currentPriority) {
                case -1 -> {
                    builder.append(" ");
                    while (checkSignPriority(symbolsStack.peek()) != 1) {
                        builder.append(symbolsStack.pop());
                    }
                    symbolsStack.pop();
                }
                case 1 -> symbolsStack.push(currentChar);
                case 2, 3 -> {
                    builder.append(" ");
                    while (!symbolsStack.empty()) {
                        if (checkSignPriority(symbolsStack.peek()) >= currentPriority) {
                            builder.append(symbolsStack.pop());
                        } else {
                            break;
                        }
                    }
                    symbolsStack.push(currentChar);
                }
                default -> {
                    builder.append(currentChar);
                }
            }
        }
        while (!symbolsStack.empty()) {
            builder.append(" ");
            builder.append(symbolsStack.pop());
        }
        return builder.toString();
    }
}
