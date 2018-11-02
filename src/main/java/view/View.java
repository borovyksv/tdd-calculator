package view;

import common.Observable;
import common.Observer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface View extends Observable {
    Queue<Input> inputs = new LinkedList<>();
    List<Observer> observers = new LinkedList<>();

    void run();
    void printResult(Integer result);

    default Queue<Input> getInputs() {
        return inputs;
    }

    @Override
    default void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    default void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
