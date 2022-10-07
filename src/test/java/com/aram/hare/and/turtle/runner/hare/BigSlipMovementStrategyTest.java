package com.aram.hare.and.turtle.runner.hare;

import com.aram.hare.and.turtle.BackwardMovementStrategyTest;
import com.aram.racing.runner.MovementStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigSlipMovementStrategyTest extends BackwardMovementStrategyTest {

    @Test
    void should_move_back_runner_by_12_positions() {
        assertTrue(raceTrack.isAtFinishingLine(runner));
        MovementStrategy movementStrategy = new BigSlipMovementStrategy();
        movementStrategy.move(runner, raceTrack);
        assertTrue(raceTrack.isRunnerAt(88, runner));
    }

}
