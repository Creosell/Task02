package by.sheshko.homework.task02;

public class MathCalc {
    private static String expression;


    public MathCalc(String expression) {
        MathCalc.expression = expression;
    }

    private MathCalc() {
    }

    public static void main(String[] args) {
        MathCalcLogic logic = new MathCalcLogic();
        ExpressionToRPN rpn = new ExpressionToRPN();

        System.out.println(rpn.convertToRPN("(222+2)/2"));
        System.out.println(logic.calculateRPN(rpn.convertToRPN("(222-(2*2))*2+(2+2)/2")));
    }


}
