package com.aram.racing.runner;

import com.aram.racing.track.RaceTrack;

public interface ForwardMovementStrategy extends LinearMovementStrategy {

    @Override
    default void move(Runner runner, RaceTrack raceTrack) {
        raceTrack.moveForward(positions(), runner);
    }

}