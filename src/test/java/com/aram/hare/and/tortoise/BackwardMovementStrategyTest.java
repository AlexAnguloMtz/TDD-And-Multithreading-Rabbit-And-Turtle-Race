package com.aram.hare.and.tortoise;

import com.aram.racing.mocks.TwentyPositionsBackwardRunner;
import com.aram.racing.track.RaceTrack;
import org.junit.jupiter.api.BeforeEach;

import static com.aram.racing.track.UnitOfLength.METER;

public abstract class BackwardMovementStrategyTest extends MovementStrategyTest {

    @BeforeEach
    void init() {
        this.raceTrack = RaceTrack.withLength(100, METER);
        this.runner = new TwentyPositionsBackwardRunner();
        raceTrack.placeAtFinishingLine(runner);
    }

}
