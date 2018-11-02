package view;

public class Input {
    Integer firstNumber;
    Integer secondNumber;
    String operator;

    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperator(String operator) {
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

    public Input() {
    }

    public Input(Integer firstNumber, Integer secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }
}
