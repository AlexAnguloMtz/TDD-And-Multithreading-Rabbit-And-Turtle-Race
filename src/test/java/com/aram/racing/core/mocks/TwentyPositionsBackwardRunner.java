package com.aram.racing.core.mocks;

import com.aram.racing.core.runner.MovementStrategy;
import com.aram.racing.core.runner.Runner;

public class TwentyPositionsBackwardRunner extends Runner {

    public TwentyPositionsBackwardRunner(String name) {
        super(name);
    }

    public TwentyPositionsBackwardRunner() {
        super("20 Positions Backward Runner");
    }

    @Override
    public MovementStrategy decideMovementStrategy() {
        return new TwentyPositionsBackwardMovementStrategy();
    }

}