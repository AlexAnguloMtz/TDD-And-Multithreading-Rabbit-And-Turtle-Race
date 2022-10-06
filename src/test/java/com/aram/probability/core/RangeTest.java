package com.aram.probability.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    @Test
    void can_recognize_if_the_specified_value_is_contained_in_this_range() {
        assertTrue(Range.of(0, 10).contains(5));
    }

    @Test
    void can_recognize_if_the_specified_value_is_not_contained_in_this_range() {
        assertFalse(Range.of(0, 10).contains(11));
        assertFalse(Range.of(0, 10).contains(-1));
    }

    @Test
    void two_ranges_are_equal_if_they_contain_the_same_floor_and_ceiling() {
        assertEquals(Range.of(0, 100), Range.of(0, 100));
    }

    @Test
    void two_ranges_are_not_equal_if_they_do_not_contain_the_same_floor() {
        assertNotEquals(Range.of(20, 100), Range.of(60, 100));
    }

    @Test
    void two_ranges_are_not_equal_if_they_do_not_contain_the_same_ceiling() {
        assertNotEquals(Range.of(0, 20), Range.of(0, 100));
    }

    @Test
    void equals_and_hash_code_are_symmetric() {
        Range first = Range.of(0, 100);
        Range second = Range.of(0, 100);
        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }


}
