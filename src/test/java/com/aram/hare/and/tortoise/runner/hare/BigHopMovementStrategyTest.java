package com.aram.hare.and.tortoise.runner.hare;

import com.aram.hare.and.tortoise.ForwardMovementStrategyTest;
import com.aram.racing.runner.MovementStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigHopMovementStrategyTest extends ForwardMovementStrategyTest {

    @Test
    void should_advance_runner_by_9_positions() {
        assertTrue(raceTrack.isAtStartingLine(runner));
        MovementStrategy movementStrategy = new BigHopMovementStrategy();
        movementStrategy.move(runner, raceTrack);
        assertTrue(raceTrack.isRunnerAt(10, runner));
    }

}
