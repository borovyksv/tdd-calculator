package model;

import java.util.*;

public class Model implements Calculable {
    @Override
    public Double add(Double first, Double second) {
        return first + second;
    }

    @Override
    public Double subtract(Double first, Double second) {
        return first - second;
    }

    @Override
    public Double divide(Double first, Double second) throws ArithmeticException {
        return first / second;
    }

    @Override
    public Double multiple(Double first, Double second) {
        return first * second;
    }

    @Override
    public Double calculate(String input) {
        List<String> elements = getCalculationElements(input);
        calculate(elements);

        return getResult(elements);
    }

    @Override
    public Double calculate(Double first, Double second, String stringOperator) {
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

    private Double calculate(String first, String second, String operator) {
        return calculate(Double.valueOf(first), Double.valueOf(second), operator);
    }

    /**
     * Split the input into an array of strings using operator delimiters "[-+/*()]" from enum {@link Operators}
     * Example input = "10 + 20 ( 30 * 40 )" into {"10", "+", "20", "(", "30", "*", "40", ")"}
     */
    private List<String> getCalculationElements(String input) {
        input = clearWhitespaces(input);
        String[] split = input.split(String.format("((?<=%1$s)|(?=%1$s))", Operators.getOperatorDelimiters()));
        return new LinkedList<>(Arrays.asList(split));
    }

    private Double getResult(List<String> elements) {
        String result = Objects.requireNonNull(elements.get(0), "Wrong number of elements after calculation:" +
                elements.size() + " , but must be 1");
        return Double.valueOf(result);
    }

    private void checkParentheses(List<String> elements) {
        while (elements.contains(Operators.OPEN_PARENTHESIS.getSymbol())) {
            int openIndex = elements.indexOf(Operators.OPEN_PARENTHESIS.getSymbol());
            int closeIndex = getCloseIndex(elements, openIndex);
            List<String> subElements = elements.subList(openIndex, closeIndex + 1);
            removeParenthesis(subElements);
            calculate(subElements);
        }
    }

    private int getCloseIndex(List<String> elements, int openIndex) {
        int closeIndex = 0;
        int openCounter = 1;
        for (int i = openIndex + 1; i < elements.size(); i++) {
            String element = elements.get(i);
            if (element.equals(Operators.OPEN_PARENTHESIS.getSymbol())) {
                openCounter++;
            } else if (element.equals(Operators.CLOSE_PARENTHESIS.getSymbol())
                    && --openCounter == 0) {
                closeIndex = i;
                break;
            }
        }
        return closeIndex;
    }

    private void removeParenthesis(List<String> subElements) {
        subElements.remove(0);
        subElements.remove(subElements.size() - 1);
    }

    private void calculateByPriority(List<String> split, Integer priority) {
        for (int i = 0; i < split.size();) {
            String current = split.get(i);
            if (current.length() == 1 && Operators.contains(current, priority)) {
                int prevIndex = i - 1;
                String first = String.valueOf(split.remove(prevIndex));
                String operator = String.valueOf(split.remove(prevIndex));
                String second = String.valueOf(split.remove(prevIndex));
                Double calculate = calculate(first, second, operator);
                split.add(prevIndex, calculate.toString());
            } else {
                i++;
            }
        }
    }

    private String clearWhitespaces(String input) {
        return input.replaceAll("\\s+", "");
    }
}
