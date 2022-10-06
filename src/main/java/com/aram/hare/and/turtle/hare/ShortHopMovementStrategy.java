package com.aram.hare.and.turtle.hare;

import com.aram.racing.core.runner.ForwardMovementStrategy;

class ShortHopMovementStrategy implements ForwardMovementStrategy {

    @Override
    public int positions() {
        return 1;
    }

}