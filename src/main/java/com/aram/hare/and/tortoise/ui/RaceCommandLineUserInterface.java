package com.aram.hare.and.tortoise.ui;

import com.aram.hare.and.tortoise.application.RaceRunnable;
import com.aram.observer.Observer;

import static java.lang.String.format;

public class RaceCommandLineUserInterface implements Observer {

    private static final String SPACE = " ";

    private final RaceRunnable runnable;

    public RaceCommandLineUserInterface(RaceRunnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void update() {
        if (!runnable.isRunnerAtFinishingLine()) {
            display(formattedPositionOfRunner());
        } else {
            display(resultsOfRunner());
        }
    }

    private String resultsOfRunner() {
        return format("%s took %d seconds to finish the race",
                runnable.nameOfRunner(), runnable.totalSeconds());
    }

    private String formattedPositionOfRunner() {
        return format("%s%s", necessarySpaces(), firstLetterOfRunnersName());
    }

    private String necessarySpaces() {
        final int necessarySpaces = runnable.positionOfRunner() - 1;
        return SPACE.repeat(necessarySpaces);
    }

    private char firstLetterOfRunnersName() {
        return runnable.nameOfRunner().charAt(0);
    }

    private void display(String message) {
        System.out.println(message);
    }

}
