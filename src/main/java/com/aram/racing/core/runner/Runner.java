package com.aram.racing.core.runner;

import com.aram.racing.assertions.Assert;
import com.aram.racing.core.race.track.RaceTrack;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

@ToString
public abstract class Runner {

    @Getter
    private final String name;

    public Runner(String name) {
        Assert.notBlank(name, "Can't create instance without a name");
        this.name = name;
    }

    public abstract MovementStrategy decideMovementStrategy();

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

    public void runIn(RaceTrack raceTrack) {
        decideMovementStrategy().move(this, raceTrack);
    }

    private void validate(Collection<MovementStrategy> movementStrategies) {
        Assert.IsNotEmpty((movementStrategies),
                format("Cannot create instance %s without movement strategies", getName()));
    }

}