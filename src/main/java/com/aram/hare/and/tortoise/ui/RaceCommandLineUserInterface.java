package com.aram.hare.and.tortoise.ui;

import com.aram.hare.and.tortoise.application.RaceRunnable;
import com.aram.observer.Observer;

import static java.lang.String.format;

public class RaceCommandLineUserInterface implements Observer {

    private static final String SPACE = " ";

    private final RaceRunnable race;

    public RaceCommandLineUserInterface(RaceRunnable runnable) {
        this.race = runnable;
    }

    @Override
    public void update() {
        if (!race.isRunnerAtFinishingLine()) {
            display(formattedPositionOfRunner());
        } else {
            display(resultsOfRunner());
        }
    }

    private String resultsOfRunner() {
        return format("%s took %d seconds to finish the race",
                race.nameOfRunner(), race.totalSeconds());
    }

    private String formattedPositionOfRunner() {
        return format("%s%s", necessarySpaces(), firstLetterOfRunnersName());
    }

    private String necessarySpaces() {
        final int necessarySpaces = race.positionOfRunner() - 1;
        return SPACE.repeat(necessarySpaces);
    }

    private char firstLetterOfRunnersName() {
        return race.nameOfRunner().charAt(0);
    }

    private void display(String message) {
        System.out.println(message);
    }

}
