package com.aram.hare.and.turtle.runner.tortoise;

import com.aram.hare.and.turtle.ForwardMovementStrategyTest;
import com.aram.racing.runner.MovementStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SlowAdvanceMovementStrategyTest extends ForwardMovementStrategyTest {

    @Test
    void should_advance_runner_by_1_position() {
        assertTrue(raceTrack.isAtStartingLine(runner));
        MovementStrategy movementStrategy = new SlowAdvanceMovementStrategy();
        movementStrategy.move(runner, raceTrack);
        assertTrue(raceTrack.isRunnerAt(2, runner));
    }

}
