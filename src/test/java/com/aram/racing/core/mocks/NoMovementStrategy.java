package com.aram.racing.core.mocks;

import com.aram.racing.core.runner.ForwardMovementStrategy;

public class NoMovementStrategy implements ForwardMovementStrategy {

    @Override
    public int positions() {
        return 0;
    }

}
