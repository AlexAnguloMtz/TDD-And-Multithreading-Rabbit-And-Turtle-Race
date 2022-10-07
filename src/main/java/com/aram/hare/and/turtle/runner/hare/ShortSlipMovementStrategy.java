package com.aram.hare.and.turtle.runner.hare;

import com.aram.racing.runner.BackwardMovementStrategy;

class ShortSlipMovementStrategy implements BackwardMovementStrategy {

    @Override
    public int positions() {
        return 2;
    }

}