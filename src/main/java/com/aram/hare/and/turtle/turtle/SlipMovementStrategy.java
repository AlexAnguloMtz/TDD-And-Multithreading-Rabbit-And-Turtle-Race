package com.aram.hare.and.turtle.turtle;

import com.aram.racing.core.runner.BackwardMovementStrategy;

class SlipMovementStrategy implements BackwardMovementStrategy {

    @Override
    public int positions() {
        return 6;
    }

}