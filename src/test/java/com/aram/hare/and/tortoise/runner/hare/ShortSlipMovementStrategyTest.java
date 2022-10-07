package com.aram.hare.and.tortoise.runner.hare;

import com.aram.hare.and.tortoise.BackwardMovementStrategyTest;
import com.aram.racing.runner.MovementStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortSlipMovementStrategyTest extends BackwardMovementStrategyTest {

    @Test
    void should_move_back_runner_by_2_positions() {
        assertTrue(raceTrack.isAtFinishingLine(runner));
        MovementStrategy movementStrategy = new ShortSlipMovementStrategy();
        movementStrategy.move(runner, raceTrack);
        assertTrue(raceTrack.isRunnerAt(98, runner));
    }

}
