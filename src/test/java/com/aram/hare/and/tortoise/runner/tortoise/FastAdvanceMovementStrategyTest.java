package com.aram.hare.and.tortoise.runner.tortoise;

import com.aram.hare.and.tortoise.ForwardMovementStrategyTest;
import com.aram.racing.runner.MovementStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FastAdvanceMovementStrategyTest extends ForwardMovementStrategyTest {

    @Test
    void should_advance_runner_by_3_positions() {
        assertTrue(raceTrack.isAtStartingLine(runner));
        MovementStrategy movementStrategy = new FastAdvanceMovementStrategy();
        movementStrategy.move(runner, raceTrack);
        assertTrue(raceTrack.isRunnerAt(4, runner));
    }

}
