package model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public enum Operators {
    PLUS("+", 2), MINUS("-", 2), OBELUS("/", 1), TIMES("*", 1),
    OPEN_PARENTHESIS("(", 1), CLOSE_PARENTHESIS(")", 1);

    private static Map<String, Operators> valuesMap = stream(values()).collect(toMap(Operators::getSymbol, identity()));
    private static List<Integer> priorities = stream(values()).map(Operators::getPriority).sorted().collect(toList());
    private static String operatorDelimiters = stream(values()).map(Operators::getSymbol).collect(joining("", "[", "]"));

    private String symbol;
    private int priority;

    Operators(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public static Optional<Operators> getOperator(String c) {
        return Optional.ofNullable(valuesMap.get(c));
    }

    public static boolean contains(String symbol, Integer priority) {
        Operators operator = valuesMap.get(symbol);
        return operator != null && priority.equals(operator.priority);
    }

    public static List<Integer> getPriorities() {
        return priorities;
    }

    public static String getOperatorDelimiters() {
        return operatorDelimiters;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }
}