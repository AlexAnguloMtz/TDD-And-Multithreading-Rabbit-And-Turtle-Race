package com.aram.racing.core.mocks;

import com.aram.racing.core.runner.MovementStrategy;
import com.aram.racing.core.runner.Runner;

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
