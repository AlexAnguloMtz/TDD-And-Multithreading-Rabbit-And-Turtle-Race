package com.aram.racing.runner;

import com.aram.racing.track.RaceTrack;

public interface BackwardMovementStrategy extends LinearMovementStrategy {

    @Override
    default void move(Runner runner, RaceTrack raceTrack) {
        raceTrack.moveBackward(positions(), runner);
    }

}