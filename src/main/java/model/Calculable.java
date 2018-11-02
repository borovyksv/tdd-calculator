package model;

public interface Calculable {
    Integer add(Integer first, Integer second);
    Integer sub(Integer first, Integer second);
    Integer div(Integer first, Integer second) throws ArithmeticException;
    Integer mult(Integer first, Integer second);

    Integer calculate(String input);
    Integer calculate(String first, String second, String operator);
    Integer calculate(Integer first, Integer second, String operator) throws UnknownOperatorException;
}
