package com.aram.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbabilityTest {

    @Test
    void stores_exact_percentages() {
        var probability = new Probability<>(new Object(), Percentage.of(4.56789012));
        assertEquals(4.56789012, probability.getPercentage());
    }

}
