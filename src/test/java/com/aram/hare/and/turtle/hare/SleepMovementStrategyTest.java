package com.aram.hare.and.turtle.hare;

import com.aram.hare.and.turtle.ForwardMovementStrategyTest;
import com.aram.racing.core.runner.MovementStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SleepMovementStrategyTest extends ForwardMovementStrategyTest {

    @Test
    void should_not_move_runner() {
        assertTrue(raceTrack.isAtStartingLine(runner));
        MovementStrategy movementStrategy = new SleepMovementStrategy();
        movementStrategy.move(runner, raceTrack);
        assertTrue(raceTrack.isAtStartingLine(runner));
    }

}
