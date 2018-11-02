package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public enum Operators {
    PLUS('+'), MINUS('-'), OBELUS('/'), TIMES('*');

    private char symbol;
    private static HashMap<Character, Operators> map;

    Operators(char symbol) {
        this.symbol = symbol;
    }

    public static Optional<Operators> getOperator(char c) {
        return Optional.ofNullable(map.get(c));
    }

    public static boolean contains(char c) {
        return map.containsKey(c);
    }

    static {
        map = new HashMap<>();
        Arrays.stream(values()).forEach(value -> map.put(value.symbol, value));
    }
}