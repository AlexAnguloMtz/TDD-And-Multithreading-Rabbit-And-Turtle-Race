package com.aram.racing.core.runner;

import com.aram.racing.core.race.track.RaceTrack;
import lombok.ToString;

public interface MovementStrategy {

    void move(Runner runner, RaceTrack raceTrack);

    int positions();

}