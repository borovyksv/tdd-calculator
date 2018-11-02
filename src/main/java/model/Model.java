package model;

import java.util.Optional;

public class Model implements Calculable {

    public Integer add(Integer first, Integer second) {
        return first + second;
    }

    public Integer sub(Integer first, Integer second) {
        return first - second;
    }

    public Integer div(Integer first, Integer second) throws ArithmeticException {
        return first / second;
    }

    public Integer mult(Integer first, Integer second) {
        return first * second;
    }

    @Override
    public Integer calculate(String input) {
        return null;
    }

    @Override
    public Integer calculate(String first, String second, String operator) {

        return 0;
    }

    public Integer calculate(Integer first, Integer second, char charOperator) {
        Optional<Operators> operator = Operators.getOperator(charOperator);
        if (operator.isPresent()) {
            switch (operator.get()) {
                case PLUS:
                    return add(first, second);
                case MINUS:
                    return sub(first, second);
                case OBELUS:
                    return div(first, second);
                case TIMES:
                    return mult(first, second);
                default:
                    throw new UnsupportedOperationException("Unsupported Operator: " + charOperator);
            }
        } else {
            throw new UnknownOperatorException("Unknown operator: " + charOperator);
        }
    }

    public Integer calculate(Integer first, Integer second, String operator) {
        return calculate(first, second, operator.charAt(0));
    }

    public String clearWhitespaces(String input) {
        return input.replaceAll("\\s+", "");
    }

}
