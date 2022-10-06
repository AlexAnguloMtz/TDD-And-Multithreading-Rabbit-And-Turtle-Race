package com.aram.hare.and.turtle;

import com.aram.racing.core.mocks.TwentyPositionsBackwardRunner;
import com.aram.racing.core.race.track.RaceTrack;
import org.junit.jupiter.api.BeforeEach;

import static com.aram.racing.core.race.track.UnitOfLength.METER;

public abstract class BackwardMovementStrategyTest extends MovementStrategyTest {

    @BeforeEach
    void init() {
        this.raceTrack = RaceTrack.withLength(100, METER);
        this.runner = new TwentyPositionsBackwardRunner();
        raceTrack.placeAtFinishingLine(runner);
    }

}
