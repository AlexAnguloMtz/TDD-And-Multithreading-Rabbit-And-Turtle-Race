package com.aram.racing.core.runner;

import com.aram.racing.core.race.track.RaceTrack;

public interface MovementStrategy {

    void move(Runner runner, RaceTrack raceTrack);

}