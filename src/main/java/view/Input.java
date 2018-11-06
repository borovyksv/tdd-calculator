package view;

public class Input {
    Double firstNumber;
    Double secondNumber;
    String operator;

    public Input() {
    }

    public Input(Double firstNumber, Double secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public String getOperator() {
        return operator;
    }
}
