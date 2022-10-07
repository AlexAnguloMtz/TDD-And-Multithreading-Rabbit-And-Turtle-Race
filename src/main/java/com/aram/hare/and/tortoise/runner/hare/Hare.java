package com.aram.hare.and.tortoise.runner.hare;

import com.aram.hare.and.tortoise.runner.ProbabilisticRunner;
import com.aram.probability.Percentage;
import com.aram.probability.Probability;
import com.aram.racing.runner.MovementStrategy;

import java.util.Collection;
import java.util.Set;

public class Hare extends ProbabilisticRunner {

    public Hare() {
        super("Hare");
    }

    @Override
    protected Collection<Probability<MovementStrategy>> movementsWithProbability() {
        return Set.of(
                new Probability<>(new BigHopMovementStrategy(), Percentage.of(20)),
                new Probability<>(new ShortHopMovementStrategy(), Percentage.of(30)),
                new Probability<>(new BigSlipMovementStrategy(), Percentage.of(10)),
                new Probability<>(new ShortSlipMovementStrategy(), Percentage.of(20)),
                new Probability<>(new SleepMovementStrategy(), Percentage.of(20))
        );
    }

}