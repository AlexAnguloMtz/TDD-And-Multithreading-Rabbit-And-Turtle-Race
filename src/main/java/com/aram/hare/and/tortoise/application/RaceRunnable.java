package com.aram.hare.and.tortoise.application;

import com.aram.common.Counter;
import com.aram.observer.Observable;
import com.aram.observer.Observer;
import com.aram.racing.track.RaceTrack;
import com.aram.racing.runner.Runner;

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
        this.timeCounter = Counter.withZero();
    }

    @Override
    public void run() {
        try {
            runRace();
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

    public int totalSeconds() {
        return timeCounter.getValue();
    }

    private void runRace() throws InterruptedException {
        setInitialState(); // Must be called before notifyInitialState();
        notifyInitialState();
        while (!raceTrack.isAtFinishingLine(runner)) {
            letTheRunnerRun();
            notifyChange();
        }
    }

    private void letTheRunnerRun() throws InterruptedException {
        runner.runIn(raceTrack);
        timeCounter.add(1);
    }

    private void setInitialState() {
        raceTrack.placeAtStartingLine(runner);
    }

    private void notifyInitialState() {
        notifyChange();
    }


}