package com.aram.hare.and.tortoise.runner.hare;

import com.aram.racing.runner.BackwardMovementStrategy;

class BigSlipMovementStrategy implements BackwardMovementStrategy {

    @Override
    public int positions() {
        return 12;
    }

}
