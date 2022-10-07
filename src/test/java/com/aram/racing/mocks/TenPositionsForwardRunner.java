package com.aram.racing.mocks;

import com.aram.racing.runner.MovementStrategy;
import com.aram.racing.runner.Runner;

public class TenPositionsForwardRunner extends Runner {

    public TenPositionsForwardRunner() {
        super("10 Positions Forward Runner");
    }

    public TenPositionsForwardRunner(String name) {
        super(name);
    }

    @Override
    public MovementStrategy decideMovementStrategy() {
        return new TenPositionsForwardMovementStrategy();
    }

}
