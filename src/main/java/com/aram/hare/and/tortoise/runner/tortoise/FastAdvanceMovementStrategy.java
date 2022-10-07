package com.aram.hare.and.tortoise.runner.tortoise;

import com.aram.racing.runner.ForwardMovementStrategy;

class FastAdvanceMovementStrategy implements ForwardMovementStrategy {

    @Override
    public int positions() {
        return 3;
    }

}
