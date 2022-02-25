package by.sheshko.homework.task02;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExpressionToReversePolishNotation {

    private int checkSignPriority(final char sign) {
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
        String formattedExpression = expression.replaceAll("[^\\d+\\-*/()]|\\s", "");
        StringBuilder builder = new StringBuilder();
        Stack<Character> symbolsStack = new Stack<>();

        if (formattedExpression.matches("(.+(-\\d+).+)|(.+[+\\-*/]-\\d+.+)")) {
            throw new RuntimeException("One of numbers is not natural!");
        }

        for (int i = 0; i < formattedExpression.length(); i++) {
            char currentChar = formattedExpression.charAt(i);
            int currentPriority = checkSignPriority(currentChar);

            switch (currentPriority) {
                case -1 -> {
                    builder.append(" ");
                    try {
                        while (checkSignPriority(symbolsStack.peek()) != 1) {
                            builder.append(symbolsStack.pop());
                        }
                        symbolsStack.pop();
                    } catch (EmptyStackException e) {
                        throw new RuntimeException("Missing opening bracket!");
                    }
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