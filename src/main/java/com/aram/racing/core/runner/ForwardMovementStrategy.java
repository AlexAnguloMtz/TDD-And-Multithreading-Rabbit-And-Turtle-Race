package com.aram.racing.core.runner;

import com.aram.racing.core.race.track.RaceTrack;
import com.aram.racing.core.runner.MovementStrategy;
import com.aram.racing.core.runner.Runner;

public interface ForwardMovementStrategy extends MovementStrategy {

    @Override
    default void move(Runner runner, RaceTrack raceTrack) {
        raceTrack.moveForward(positions(), runner);
    }

}