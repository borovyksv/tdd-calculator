package controller;

import common.Observer;
import model.Model;
import view.Input;
import view.View;

public class Controller implements Observer {
    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.addObserver(this);
    }

    public void run() {
        view.run();
    }

    @Override
    public void update() {
        Input input = null;
        while ((input = view.getInputs().poll()) != null) {
            Double result = getCalculatedResult(input);
            if (result != null) {
                view.printResult(result);
            }
        }
    }

    private Double getCalculatedResult(Input input) {
        try {
            return model.calculate(input.getFirstNumber(), input.getSecondNumber(), input.getOperator());
        } catch (Exception e) {
            printError(e);
        }
        return null;
    }

    private void printError(Exception e) {
        System.err.println(e.getMessage());
    }
}
