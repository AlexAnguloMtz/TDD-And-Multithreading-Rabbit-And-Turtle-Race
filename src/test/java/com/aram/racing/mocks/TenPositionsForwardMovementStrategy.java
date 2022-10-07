package com.aram.racing.mocks;

import com.aram.racing.runner.ForwardMovementStrategy;

public class TenPositionsForwardMovementStrategy implements ForwardMovementStrategy {

    @Override
    public int positions() {
        return 10;
    }

}
