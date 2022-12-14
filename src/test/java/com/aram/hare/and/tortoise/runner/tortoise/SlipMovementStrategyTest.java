package com.aram.hare.and.tortoise.runner.tortoise;

import com.aram.hare.and.tortoise.BackwardMovementStrategyTest;
import com.aram.racing.runner.MovementStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SlipMovementStrategyTest extends BackwardMovementStrategyTest {

    @Test
    void should_move_back_runner_by_6_positions() {
        assertTrue(raceTrack.isAtFinishingLine(runner));
        MovementStrategy movementStrategy = new SlipMovementStrategy();
        movementStrategy.move(runner, raceTrack);
        assertTrue(raceTrack.isRunnerAt(94, runner));
    }

}
