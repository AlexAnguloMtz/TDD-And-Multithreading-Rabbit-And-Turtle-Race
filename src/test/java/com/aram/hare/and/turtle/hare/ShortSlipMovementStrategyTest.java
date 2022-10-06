package com.aram.hare.and.turtle.hare;

import com.aram.hare.and.turtle.BackwardMovementStrategyTest;
import com.aram.racing.core.runner.MovementStrategy;
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
