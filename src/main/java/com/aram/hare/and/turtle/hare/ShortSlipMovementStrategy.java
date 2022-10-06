package com.aram.hare.and.turtle.hare;

import com.aram.racing.core.runner.BackwardMovementStrategy;

class ShortSlipMovementStrategy implements BackwardMovementStrategy {

    @Override
    public int positions() {
        return 2;
    }

}