package com.aram.racing.runner;

import com.aram.racing.mocks.TenPositionsForwardRunner;
import com.aram.racing.mocks.TwentyPositionsBackwardRunner;
import com.aram.racing.track.RaceTrack;
import com.aram.racing.runner.Runner;
import com.aram.racing.track.UnitOfLength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {

    private Runner firstFrog;
    private Runner secondFrog;
    private Runner lizardRunner;

    @BeforeEach
    void init() {
        this.firstFrog = new TenPositionsForwardRunner("Frog");
        this.secondFrog = new TwentyPositionsBackwardRunner("Frog");
        this.lizardRunner = new TenPositionsForwardRunner("Lizard");
    }

    @Test
    void cannot_create_child_class_instance_with_null_name() {
        assertThrows(IllegalArgumentException.class,
                () -> new TenPositionsForwardRunner(null));
    }

    @Test
    void cannot_create_child_class_instance_with_empty_name() {
        assertThrows(IllegalArgumentException.class,
                () -> new TenPositionsForwardRunner(""));
    }

    @Test
    void two_runners_are_equal_if_they_have_the_same_name() {
        assertEquals(firstFrog, secondFrog);
    }

    @Test
    void two_runners_are_not_equal_if_they_have_different_names() {
        assertNotEquals(firstFrog, lizardRunner);
    }

    @Test
    void two_runners_have_the_same_hash_code_if_they_are_equal() {
        assertEquals(firstFrog, secondFrog);
        assertEquals(firstFrog.hashCode(), secondFrog.hashCode());
    }

    @Test
    void runner_can_decide_how_to_move_in_a_race_track() {
        RaceTrack raceTrack = RaceTrack.withLength(100, UnitOfLength.METER);

        Runner tenPositionsForwardRunner = new TenPositionsForwardRunner();
        raceTrack.placeAtStartingLine(tenPositionsForwardRunner);
        assertTrue(raceTrack.isAtStartingLine(tenPositionsForwardRunner));
        tenPositionsForwardRunner.runIn(raceTrack);
        assertTrue(raceTrack.isRunnerAt(11, tenPositionsForwardRunner));

        Runner twentyPositionsBackwardRunner = new TwentyPositionsBackwardRunner();
        raceTrack.placeAtFinishingLine(twentyPositionsBackwardRunner);
        assertTrue(raceTrack.isAtFinishingLine(twentyPositionsBackwardRunner));
        twentyPositionsBackwardRunner.runIn(raceTrack);
        assertTrue(raceTrack.isRunnerAt(80, twentyPositionsBackwardRunner));
    }

}