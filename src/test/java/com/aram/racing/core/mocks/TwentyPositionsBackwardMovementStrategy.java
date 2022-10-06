package com.aram.racing.core.mocks;

import com.aram.racing.core.runner.BackwardMovementStrategy;

public class TwentyPositionsBackwardMovementStrategy implements BackwardMovementStrategy {

    @Override
    public int positions() {
        return 20;
    }

}

