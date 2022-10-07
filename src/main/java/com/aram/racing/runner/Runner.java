package com.aram.racing.runner;

import com.aram.common.Assert;
import com.aram.racing.track.RaceTrack;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@ToString
public abstract class Runner {

    @Getter
    private final String name;

    public Runner(String name) {
        Assert.notBlank(name, "Can't create instance without a name");
        this.name = name;
    }

    public abstract MovementStrategy decideMovementStrategy();

    public void runIn(RaceTrack raceTrack) {
        decideMovementStrategy().move(this, raceTrack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Runner)) return false;
        Runner runner = (Runner) o;
        return Objects.equals(name, runner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}