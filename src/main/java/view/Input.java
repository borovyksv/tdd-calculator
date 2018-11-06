package view;

public class Input {
    Integer firstNumber;
    Integer secondNumber;
    String operator;

    public Input() {
    }

    public Input(Integer firstNumber, Integer secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public String getOperator() {
        return operator;
    }
}
