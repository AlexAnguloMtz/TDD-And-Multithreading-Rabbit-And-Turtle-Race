package com.aram.racing.track;

import com.aram.common.Assert;
import com.aram.common.Range;
import com.aram.racing.runner.Runner;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.String.format;

@Getter
@ToString
public class RaceTrack {

    private static final int STARTING_LINE = 1;

    private final Map<Runner, Integer> track;

    private final Length length;

    private RaceTrack(Length length) {
        this.track = new HashMap<>();
        this.length = length;
    }

    public static RaceTrack withLength(int measure, UnitOfLength unit) {
        return new RaceTrack(Length.of(measure, unit));
    }

    public int numberOfRunners() {
        return runners().size();
    }

    public int positionOf(Runner runner) {
        return track.get(runner);
    }

    public void placeAtStartingLine(Runner runner) {
        placeAt(STARTING_LINE, runner);
    }

    public void placeAllAtStartingLine(Collection<? extends Runner> runners) {
        Assert.isNotEmpty(runners, "No runners found");
        runners.forEach(this::placeAtStartingLine);
    }

    public void placeAtFinishingLine(Runner runner) {
        placeAt(finishingLine(), runner);
    }

    public void moveForward(int positionsToMove, Runner runner) {
        move(positionsToMove, runner);
    }

    public void moveBackward(int positionsToMove, Runner runner) {
        move( - positionsToMove, runner);
    }

    public boolean isRunnerAt(int position, Runner runner) {
        return positionOf(runner) == position;
    }

    public boolean isAtStartingLine(Runner runner) {
        return isRunnerAt(startingLine(), runner);
    }

    public boolean isAtFinishingLine(Runner runner) {
        return isRunnerAt(finishingLine(), runner);
    }

    private void assertIsActiveRunner(Runner runner) {
        if (!isActiveRunner(runner)) {
            throw new RunnerNotInTrackException(format(
                "Cannot move runner %s because " +
                "it is not an active runner in this track",
                runner.getName()));
        }
    }

    private boolean isActiveRunner(Runner runner) {
        return track.containsKey(runner);
    }

    private void move(int positionsToMove, Runner runner) {
        assertIsActiveRunner(runner);
        final int calculatedPosition = calculateNextPosition(positionsToMove, runner);
        placeAt(calculatedPosition, runner);
    }

    private int calculateNextPosition(int positionsToMove, Runner runner) {
        final int calculatedPosition = positionOf(runner) + positionsToMove;
        return isValidPosition(calculatedPosition) ? calculatedPosition : fixedOutOfBoundsPosition(calculatedPosition);
    }

    private boolean isValidPosition(int position) {
        return Range.isBetween(startingLine(), finishingLine(), position);
    }

    private int fixedOutOfBoundsPosition(int calculatedPosition) {
        return calculatedPosition < startingLine() ? startingLine() : finishingLine();
    }

    private void placeAt(int position, Runner runner) {
        track.put(runner, position);
    }

    private int startingLine() {
        return STARTING_LINE;
    }

    private int finishingLine() {
        return length.getMeasure();
    }

    private Set<Runner> runners() {
        return track.keySet();
    }

}