package com.aram.hare.and.turtle.application;

import com.aram.counter.Counter;
import com.aram.observer.Observable;
import com.aram.observer.Observer;
import com.aram.racing.core.race.track.RaceTrack;
import com.aram.racing.core.runner.Runner;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.sleep;

public class RaceRunnable implements Observable, Runnable {

    private final Runner runner;
    private final RaceTrack raceTrack;
    private final Set<Observer> observers;
    private final Counter timeCounter;

    public RaceRunnable(Runner runner, RaceTrack raceTrack) {
        this.runner = runner;
        this.raceTrack = raceTrack;
        this.observers = new HashSet<>();
        this.timeCounter = new Counter();
    }

    @Override
    public void run() {
        try {
            runUntilRunnerArrivesToFinishingLine();
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyChange() {
        observers.forEach(Observer::update);
    }

    public int positionOfRunner() {
        return raceTrack.positionOf(runner);
    }

    public String nameOfRunner() {
        return runner.getName();
    }

    public boolean isRunnerAtFinishingLine() {
        return raceTrack.isAtFinishingLine(runner);
    }

    private void runUntilRunnerArrivesToFinishingLine() throws InterruptedException {
        raceTrack.placeAtStartingLine(runner); // Must be called before notifyInitialState();
        notifyInitialState();
        while (!raceTrack.isAtFinishingLine(runner)) {
            runner.runIn(raceTrack);
            sleep(1000);
            timeCounter.add(1);
            notifyChange();
        }
    }

    private void notifyInitialState() {
        notifyChange();
    }

    public int totalSeconds() {
        return timeCounter.getValue();
    }

}