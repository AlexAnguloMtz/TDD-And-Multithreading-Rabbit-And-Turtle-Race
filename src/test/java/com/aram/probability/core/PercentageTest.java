package com.aram.probability.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PercentageTest {

    @Test
    void cannot_create_negative_percentage() {
        assertThrows(IllegalPercentageException.class,
                () -> Percentage.of(-500));
    }

    @Test
    void cannot_create_percentage_above_one_hundred() {
        assertThrows(IllegalPercentageException.class,
                () -> Percentage.of(900));
    }

    @Test
    void cannot_create_percentage_above_one_hundred() {
        assertThrows(IllegalPercentageException.class,
                () -> Percentage.of(900));
    }

}
