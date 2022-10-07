package com.aram.racing.mocks;

import com.aram.racing.runner.BackwardMovementStrategy;

public class TwentyPositionsBackwardMovementStrategy implements BackwardMovementStrategy {

    @Override
    public int positions() {
        return 20;
    }

}

