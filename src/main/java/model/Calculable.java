package model;

public interface Calculable {
    Integer add(Integer first, Integer second);
    Integer subtract(Integer first, Integer second);
    Integer divide(Integer first, Integer second) throws ArithmeticException;
    Integer multiple(Integer first, Integer second);

    Integer calculate(String input);
    Integer calculate(Integer first, Integer second, String operator) throws UnknownOperatorException;
}
