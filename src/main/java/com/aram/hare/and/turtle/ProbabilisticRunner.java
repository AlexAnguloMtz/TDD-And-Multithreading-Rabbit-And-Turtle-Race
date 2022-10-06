package com.aram.hare.and.turtle;

import com.aram.probability.core.ProbabilisticChooser;
import com.aram.probability.core.Probability;
import com.aram.racing.core.runner.MovementStrategy;
import com.aram.racing.core.runner.Runner;

import java.util.Collection;

public abstract class ProbabilisticRunner extends Runner {

    private final ProbabilisticChooser<MovementStrategy> probabilityChooser;

    public ProbabilisticRunner(String name) {
        super(name);
        this.probabilityChooser = new ProbabilisticChooser<>();
    }

    protected abstract Collection<Probability<MovementStrategy>> movementsWithProbability();

    @Override
    public MovementStrategy decideMovementStrategy() {
        return movementStrategyIn(selectOneBasedOnProbability());
    }

    private Probability<MovementStrategy> selectOneBasedOnProbability() {
        return probabilityChooser.pickOneFrom(movementsWithProbability());
    }

    private MovementStrategy movementStrategyIn(Probability<MovementStrategy> probability) {
        return probability.getContent();
    }

}
