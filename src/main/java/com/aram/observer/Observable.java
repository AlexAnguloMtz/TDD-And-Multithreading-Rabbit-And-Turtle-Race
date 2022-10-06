package com.aram.observer;

public interface Observable {

    void notifyChange();

    void addObserver(Observer observer);

}