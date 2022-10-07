package com.aram.probability;

import com.aram.common.Range;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.lang.String.format;

public class ProbabilisticChooser <T> {

    private static final double REQUIRED_TOTAL_PROBABILITY = 100;

    private static final Range VALID_RANGE = Range.of(0, REQUIRED_TOTAL_PROBABILITY);

    public Probability<T> pickOneFrom(Collection<Probability<T>> probabilities) {
        validate(probabilities);
        Map<Range, Probability<T>> rangesWithProbabilities = assignRanges(probabilities);
        Range selectedRange = findRangeContaining(randomDouble(), rangesWithProbabilities);
        Probability<T> selectedProbability = rangesWithProbabilities.get(selectedRange);
        return selectedProbability;
    }

    private double randomDouble() {
        return VALID_RANGE.random();
    }

    private Range findRangeContaining(double aDouble, Map<Range, Probability<T>> rangesWithProbabilities) {
        return rangesWithProbabilities.keySet().stream()
                .filter(range -> range.contains(aDouble))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(format("No Range containing %f", aDouble)));
    }

    private Map<Range, Probability<T>> assignRanges(Collection<Probability<T>> probabilities) {
        double counter = 0;
        double previousValue;
        var probabilitiesWithRange = new HashMap<Range, Probability<T>>();
        for (Probability<T> probability : probabilities) {
            previousValue = counter;
            counter += probability.getPercentage();
            probabilitiesWithRange.put(Range.of(previousValue, counter), probability);
        }
        return probabilitiesWithRange;
    }

    private void validate(Collection<Probability<T>> probabilities) {
        if (!isValidTotalProbability(probabilities)) {
            throw new IllegalArgumentException(format(
                "Cannot pick an element because these probabilities do not sum exactly %f",
                REQUIRED_TOTAL_PROBABILITY));
        }
    }

    private boolean isValidTotalProbability(Collection<Probability<T>> probabilities) {
        return totalProbability(probabilities) == REQUIRED_TOTAL_PROBABILITY;
    }

    private double totalProbability(Collection<Probability<T>> probabilities) {
        return probabilities.stream()
                .mapToDouble(Probability::getPercentage)
                .sum();
    }

}
