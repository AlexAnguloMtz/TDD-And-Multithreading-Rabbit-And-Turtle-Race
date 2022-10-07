package com.aram.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PercentageTest {

    @Test
    void cannot_create_negative_percentage() {
        assertThrows(IllegalPercentageException.class,
                () -> Percentage.of(-0.00001));
    }

    @Test
    void cannot_create_percentage_above_one_hundred() {
        assertThrows(IllegalPercentageException.class,
                () -> Percentage.of(100.0001));
    }

}
