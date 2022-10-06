package com.aram.racing.core;

import com.aram.racing.core.mocks.LazyRunner;
import com.aram.racing.core.mocks.TenPositionsForwardRunner;
import com.aram.racing.core.race.track.Length;
import com.aram.racing.core.race.track.RaceTrack;
import com.aram.racing.core.race.track.RunnerNotInTrackException;
import com.aram.racing.core.runner.Runner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.aram.racing.core.race.track.UnitOfLength.METER;
import static org.junit.jupiter.api.Assertions.*;

public class RaceTrackTest {

    private RaceTrack raceTrack;
    private Runner runner;
    private List<Runner> runners;

    @BeforeEach
    void init() {
        this.raceTrack = RaceTrack.withLength(100, METER);
        this.runner = new TenPositionsForwardRunner();
        this.runners = List.of(
                new LazyRunner("First"),
                new LazyRunner("Second")
        );
    }

    @Test
    void cannot_create_race_track_with_length_zero() {
        assertThrows(IllegalArgumentException.class,
                () -> RaceTrack.withLength(0, METER));
    }

    @Test
    void cannot_create_race_track_with_negative_length() {
        assertThrows(IllegalArgumentException.class,
                () -> RaceTrack.withLength( -100,  METER));
    }

    @Test
    void race_track_remembers_its_length_and_unit_of_length() {
        assertEquals(Length.of(100, METER), raceTrack.getLength());
    }

    @Test
    void knows_how_many_runners_are_there() {
        raceTrack.placeAtStartingLine(runners);
        assertEquals(2, raceTrack.numberOfRunners());
    }

    @Test
    void race_track_can_add_one_runner_at_the_starting_line() {
        raceTrack.placeAtStartingLine(runner);
        assertTrue(raceTrack.isAtStartingLine(runner));
    }

    @Test
    void race_track_can_add_multiple_runners_at_the_starting_line() {
        raceTrack.placeAtStartingLine(runners);
        runners.forEach(runner -> assertTrue(raceTrack.isAtStartingLine(runner)));
    }

    @Test
    void race_track_can_add_one_runner_at_the_finishing_line() {
        raceTrack.placeAtFinishingLine(runner);
        assertTrue(raceTrack.isAtFinishingLine(runner));
    }

    @Test
    void when_a_runner_is_placed_at_the_starting_line_their_position_is_one() {
        raceTrack.placeAtStartingLine(runner);
        assertTrue(raceTrack.isRunnerAt(1, runner));
    }

    @Test
    void race_track_can_move_runner_forward_and_backward() {
        raceTrack.placeAtStartingLine(runner);
        raceTrack.moveForward(9, runner);
        assertTrue(raceTrack.isRunnerAt(10, runner));

        raceTrack.moveBackward(5, runner);
        assertTrue(raceTrack.isRunnerAt(5, runner));
    }

    @Test
    void runner_is_moved_to_starting_line_when_desired_position_is_too_low() {
        raceTrack.placeAtStartingLine(runner);
        raceTrack.moveForward(49, runner);
        raceTrack.moveBackward(500, runner);
        assertTrue(raceTrack.isAtStartingLine(runner));
    }

    @Test
    void runner_is_moved_to_finishing_line_when_desired_position_is_too_high() {
        raceTrack.placeAtStartingLine(runner);
        raceTrack.moveForward(900, runner);
        assertTrue(raceTrack.isAtFinishingLine(runner));
    }

    @Test
    void throws_exception_when_trying_to_move_forward_a_runner_that_is_not_present_in_the_race_track() {
        Runner runnerThatHasNotBeenAddedToTheRaceTrack = new TenPositionsForwardRunner();
        assertThrows(RunnerNotInTrackException.class,
                () -> raceTrack.moveForward(1, runnerThatHasNotBeenAddedToTheRaceTrack));
    }

    @Test
    void throws_exception_when_trying_to_move_backward_a_runner_that_is_not_present_in_the_race_track() {
        Runner runnerThatHasNotBeenAddedToTheRaceTrack = new TenPositionsForwardRunner();
        assertThrows(RunnerNotInTrackException.class,
                () -> raceTrack.moveBackward(1, runnerThatHasNotBeenAddedToTheRaceTrack));
    }

}