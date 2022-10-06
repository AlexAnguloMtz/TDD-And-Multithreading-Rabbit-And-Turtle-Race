package com.aram.racing.core.mocks;

import com.aram.hare.and.turtle.hare.SleepMovementStrategy;
import com.aram.racing.core.runner.MovementStrategy;
import com.aram.racing.core.runner.Runner;

public class LazyRunner extends Runner {

    public LazyRunner(String name) {
        super(name);
    }

    @Override
    public MovementStrategy decideMovementStrategy() {
        return new SleepMovementStrategy();
    }

}
