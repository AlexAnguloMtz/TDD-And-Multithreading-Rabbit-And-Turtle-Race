package com.aram.racing.mocks;

import com.aram.racing.runner.MovementStrategy;
import com.aram.racing.runner.Runner;

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