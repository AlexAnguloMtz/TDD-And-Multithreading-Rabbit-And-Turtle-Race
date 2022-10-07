package com.aram.hare.and.tortoise.runner.hare;

import com.aram.racing.runner.ForwardMovementStrategy;

class ShortHopMovementStrategy implements ForwardMovementStrategy {

    @Override
    public int positions() {
        return 1;
    }

}