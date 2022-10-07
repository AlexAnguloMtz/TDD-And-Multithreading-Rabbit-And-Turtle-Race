package com.aram.racing.runner;

import com.aram.racing.track.RaceTrack;

public interface MovementStrategy {

    void move(Runner runner, RaceTrack raceTrack);

}