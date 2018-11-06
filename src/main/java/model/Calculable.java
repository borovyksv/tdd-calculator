package model;

public interface Calculable {
    Double add(Double first, Double second);
    Double subtract(Double first, Double second);
    Double divide(Double first, Double second) throws ArithmeticException;
    Double multiple(Double first, Double second);

    Double calculate(String input);
    Double calculate(Double first, Double second, String operator) throws UnknownOperatorException;
}
