package model;

import java.util.*;

public class Model implements Calculable {
    @Override
    public Integer add(Integer first, Integer second) {
        return first + second;
    }

    @Override
    public Integer subtract(Integer first, Integer second) {
        return first - second;
    }

    @Override
    public Integer divide(Integer first, Integer second) throws ArithmeticException {
        return first / second;
    }

    @Override
    public Integer multiple(Integer first, Integer second) {
        return first * second;
    }

    @Override
    public Integer calculate(String input) {
        List<String> elements = getCalculationElements(input);
        calculate(elements);

        return getResult(elements);
    }

    @Override
    public Integer calculate(Integer first, Integer second, String stringOperator) {
        Optional<Operators> operator = Operators.getOperator(stringOperator);
        if (operator.isPresent()) {
            switch (operator.get()) {
                case PLUS:
                    return add(first, second);
                case MINUS:
                    return subtract(first, second);
                case OBELUS:
                    return divide(first, second);
                case TIMES:
                    return multiple(first, second);
                default:
                    throw new UnsupportedOperationException("Unsupported Operator: " + stringOperator);
            }
        } else {
            throw new UnknownOperatorException("Unknown operator: " + stringOperator);
        }
    }

    private void calculate(List<String> elements) {
        checkParentheses(elements);
        Operators.getPriorities().forEach(priority -> calculateByPriority(elements, priority));
    }

    private Integer calculate(String first, String second, String operator) {
        return calculate(Integer.valueOf(first), Integer.valueOf(second), operator);
    }

    /** Split the input into an array of strings using operator delimiters "[-+/*()]" from enum {@link Operators}
     *   Example input = "10 + 20 ( 30 * 40 )" into {"10", "+", "20", "(", "30", "*", "40", ")"} */
    private List<String> getCalculationElements(String input) {
        input = clearWhitespaces(input);
        String[] split = input.split(String.format("((?<=%1$s)|(?=%1$s))", Operators.getOperatorDelimiters()));
        return new LinkedList<>(Arrays.asList(split));
    }

    private Integer getResult(List<String> elements) {
        String result = Objects.requireNonNull(elements.get(0), "Wrong number of elements after calculation:" +
                elements.size() + " , but must be 1");
        return Integer.valueOf(result);
    }

    private void checkParentheses(List<String> elements) {
        if (elements.contains(Operators.OPEN_PARENTHESIS.getSymbol())) {
            int open = elements.indexOf(Operators.OPEN_PARENTHESIS.getSymbol());
            int close = elements.lastIndexOf(Operators.CLOSE_PARENTHESIS.getSymbol());
            List<String> subElements = elements.subList(open, close + 1);
            removeParenthesis(subElements);
            calculate(subElements);
        }
    }

    private void removeParenthesis(List<String> subElements) {
        subElements.remove(0);
        subElements.remove(subElements.size() - 1);
    }

    private void calculateByPriority(List<String> split, Integer priority) {
        for (int i = 0; i < split.size(); i++) {
            String current = split.get(i);
            if (current.length() == 1 && Operators.contains(current, priority)) {
                int prevIndex = i - 1;
                String first = String.valueOf(split.remove(prevIndex));
                String operator = String.valueOf(split.remove(prevIndex));
                String second = String.valueOf(split.remove(prevIndex));
                Integer calculate = calculate(first, second, operator);
                split.add(prevIndex, calculate.toString());
            }
        }
    }

    private String clearWhitespaces(String input) {
        return input.replaceAll("\\s+", "");
    }
}
