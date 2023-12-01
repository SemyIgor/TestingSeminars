package seminars.first.hw;

public class Calculator {
    public static float calculate(int firstOperand, int secondOperand, char operator) {
        float result;
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = (float) firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Ошибка - деление на 0");
                }
                // break;
            case '^':
                //                    result = (float) Math.pow(firstOperand, secondOperand);
                if (!(firstOperand < 0)) {
                    result = Math.round(Math.pow(firstOperand, (float) 1 / secondOperand));
                } else {
                    throw new AssertionError("Root of a negative number");
                }
                break;
            default:
//                throw new IllegalStateException("Ошибка! Неверно указан оператор " + "'" + operator + "'");
                throw new IllegalStateException("Ошибка! Неверно указан оператор");
        }
        return result;
    }

    public static double calculatingDiscount(double purchaseAmount, int discountAmount){
        if(purchaseAmount < 0) throw new RuntimeException("Negative purchase amount");
        if(discountAmount < 0) throw new IllegalStateException("Negative discount");
        else if (discountAmount > 100) throw new IllegalStateException("Too much discount");
        else return purchaseAmount * (1.0 - discountAmount / 100.0);

    }
}
