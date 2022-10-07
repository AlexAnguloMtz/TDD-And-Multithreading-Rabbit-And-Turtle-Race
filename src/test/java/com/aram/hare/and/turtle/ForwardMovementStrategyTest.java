package com.aram.hare.and.turtle;

import com.aram.racing.mocks.TenPositionsForwardRunner;
import com.aram.racing.track.RaceTrack;
import org.junit.jupiter.api.BeforeEach;

import static com.aram.racing.track.UnitOfLength.METER;

public abstract class ForwardMovementStrategyTest extends MovementStrategyTest {

    @BeforeEach
    void init() {
        this.raceTrack = RaceTrack.withLength(100, METER);
        this.runner = new TenPositionsForwardRunner();
        raceTrack.placeAtStartingLine(runner);
    }

}