package com.aram.racing.core.mocks;

import com.aram.racing.core.runner.ForwardMovementStrategy;

public class TenPositionsForwardMovementStrategy implements ForwardMovementStrategy {

    @Override
    public int positions() {
        return 10;
    }

}
