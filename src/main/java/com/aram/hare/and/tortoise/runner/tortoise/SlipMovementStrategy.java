package com.aram.hare.and.tortoise.runner.tortoise;

import com.aram.racing.runner.BackwardMovementStrategy;

class SlipMovementStrategy implements BackwardMovementStrategy {

    @Override
    public int positions() {
        return 6;
    }

}