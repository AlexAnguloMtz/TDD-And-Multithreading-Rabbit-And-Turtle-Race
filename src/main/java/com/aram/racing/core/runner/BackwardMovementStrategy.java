package com.aram.racing.core.runner;

import com.aram.racing.core.race.track.RaceTrack;

public interface BackwardMovementStrategy extends LinearMovementStrategy {

    @Override
    default void move(Runner runner, RaceTrack raceTrack) {
        raceTrack.moveBackward(positions(), runner);
    }

}