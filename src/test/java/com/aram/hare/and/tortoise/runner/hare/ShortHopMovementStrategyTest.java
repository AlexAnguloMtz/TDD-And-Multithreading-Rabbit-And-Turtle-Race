package com.aram.hare.and.tortoise.runner.hare;

import com.aram.hare.and.tortoise.ForwardMovementStrategyTest;
import com.aram.racing.runner.MovementStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortHopMovementStrategyTest extends ForwardMovementStrategyTest {

    @Test
    void should_advance_runner_by_1_position() {
        assertTrue(raceTrack.isAtStartingLine(runner));
        MovementStrategy movementStrategy = new ShortHopMovementStrategy();
        movementStrategy.move(runner, raceTrack);
        assertTrue(raceTrack.isRunnerAt(2, runner));
    }

}
