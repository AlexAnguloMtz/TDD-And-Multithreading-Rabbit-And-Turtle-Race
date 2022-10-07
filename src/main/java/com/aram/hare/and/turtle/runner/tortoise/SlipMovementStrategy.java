package com.aram.hare.and.turtle.runner.tortoise;

import com.aram.racing.runner.BackwardMovementStrategy;

class SlipMovementStrategy implements BackwardMovementStrategy {

    @Override
    public int positions() {
        return 6;
    }

}