package com.aram.hare.and.tortoise.runner.tortoise;

import com.aram.racing.runner.ForwardMovementStrategy;

class SlowAdvanceMovementStrategy implements ForwardMovementStrategy {

    @Override
    public int positions() {
        return 1;
    }

}
