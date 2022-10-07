package com.aram.hare.and.tortoise.runner.tortoise;

import com.aram.hare.and.tortoise.runner.ProbabilisticRunner;
import com.aram.probability.Percentage;
import com.aram.probability.Probability;
import com.aram.racing.runner.MovementStrategy;

import java.util.Collection;
import java.util.Set;

public class Tortoise extends ProbabilisticRunner {

    public Tortoise() {
        super("Tortoise");
    }

    @Override
    protected Collection<Probability<MovementStrategy>> movementsWithProbability() {
        return Set.of(
                new Probability<>(new FastAdvanceMovementStrategy(), Percentage.of(50)),
                new Probability<>(new SlowAdvanceMovementStrategy(), Percentage.of(30)),
                new Probability<>(new SlipMovementStrategy(), Percentage.of(20))
        );
    }

}
