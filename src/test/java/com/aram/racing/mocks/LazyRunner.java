package com.aram.racing.mocks;

import com.aram.racing.runner.MovementStrategy;
import com.aram.racing.runner.Runner;

public class LazyRunner extends Runner {

    public LazyRunner(String name) {
        super(name);
    }

    @Override
    public MovementStrategy decideMovementStrategy() {
        return new NoMovementStrategy();
    }

}
