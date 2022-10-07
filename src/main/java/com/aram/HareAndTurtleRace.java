package com.aram;

import com.aram.hare.and.turtle.application.RaceRunnable;
import com.aram.hare.and.turtle.runner.hare.Hare;
import com.aram.hare.and.turtle.runner.tortoise.Tortoise;
import com.aram.hare.and.turtle.ui.RaceCommandLineUserInterface;
import com.aram.observer.Observer;
import com.aram.racing.track.RaceTrack;
import com.aram.racing.runner.Runner;

import java.util.Set;

import static com.aram.racing.track.UnitOfLength.METER;

public class HareAndTurtleRace {

    public static void main(String[] args) {

        RaceTrack raceTrack = RaceTrack.withLength(100, METER);

        Runner hare = new Hare();
        Runner tortoise = new Tortoise();

        Set<RaceRunnable> runnables = Set.of(
                new RaceRunnable(hare, raceTrack),
                new RaceRunnable(tortoise, raceTrack)
        );

        runnables.forEach(runnable -> configureAndRun(runnable));
    }

    private static void configureAndRun(RaceRunnable runnable) {

        Observer userInterface = new RaceCommandLineUserInterface(runnable);

        runnable.addObserver(userInterface);

        new Thread(runnable).start();

    }

}
