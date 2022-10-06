package com.aram.hare.and.turtle.turtle;

import com.aram.hare.and.turtle.ProbabilisticRunner;
import com.aram.probability.core.Percentage;
import com.aram.probability.core.Probability;
import com.aram.racing.core.runner.MovementStrategy;

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
