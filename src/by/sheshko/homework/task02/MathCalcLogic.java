package by.sheshko.homework.task02;

import java.util.Stack;

public class MathCalcLogic {

    public double calculateRPN(String expressionRPN) {
        Stack<Double> stackOfDigits = new Stack<>();
        StringBuilder builder = new StringBuilder();


        for (int i = 0; i < expressionRPN.length(); i++) {
            char currentChar = expressionRPN.charAt(i);

            if (currentChar != ' ') {
                if (Character.isDigit(currentChar)) {
                    builder.append(currentChar);
                    continue;
                }

                double temp;
                switch (currentChar) {
                    case '+' -> {
                        temp = stackOfDigits.pop() + stackOfDigits.pop();
                        stackOfDigits.push(temp);
                        continue;
                    }
                    case '-' -> {
                        double stackTemp = stackOfDigits.pop();
                        temp = stackOfDigits.pop() - stackTemp;
                        stackOfDigits.push(temp);
                        continue;
                    }
                    case '*' -> {
                        temp = stackOfDigits.pop() * stackOfDigits.pop();
                        stackOfDigits.push(temp);
                        continue;
                    }
                    case '/' -> {
                        double stackTemp = stackOfDigits.pop();
                        temp = stackOfDigits.pop() / stackTemp;
                        stackOfDigits.push(temp);
                        continue;
                    }
                }
            }


                if (currentChar!=' ' || !builder.isEmpty()){
                    stackOfDigits.push(Double.valueOf(builder.toString()));
                    builder.setLength(0);
                }


        }
        return stackOfDigits.pop();
    }
}
