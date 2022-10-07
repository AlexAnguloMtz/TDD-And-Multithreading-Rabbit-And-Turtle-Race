package com.aram.racing.track;

import com.aram.racing.track.Length;
import com.aram.racing.track.UnitOfLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    void cannot_create_instance_with_negative_measure() {
        assertThrows(IllegalArgumentException.class,
                () -> Length.of(-1, UnitOfLength.METER));
    }

    @Test
    void cannot_create_instance_with_measure_equal_to_zero() {
        assertThrows(IllegalArgumentException.class,
                () -> Length.of(0, UnitOfLength.METER));
    }

    @Test
    void cannot_create_instance_with_null_unit_of_length() {
        assertThrows(NullPointerException.class,
                () -> Length.of(1, null));
    }

    @Test
    void two_lengths_are_equal_if_they_have_the_same_measure_and_unit_of_length() {
        Length first = Length.of(10, UnitOfLength.METER);
        Length second = Length.of(10, UnitOfLength.METER);
        assertEquals(first, second);
    }

    @Test
    void two_lengths_are_not_equal_if_they_do_not_have_the_same_measure() {
        Length first = Length.of(10, UnitOfLength.METER);
        Length second = Length.of(200, UnitOfLength.METER);
        assertNotEquals(first, second);
    }

    @Test
    void two_lengths_are_not_equal_if_they_do_not_have_the_same_unit_of_length() {
        Length first = Length.of(10, UnitOfLength.METER);
        Length second = Length.of(10, UnitOfLength.KILOMETER);
        assertNotEquals(first, second);
    }

    @Test
    void two_lengths_have_the_same_hash_code_if_they_are_equal() {
        Length first = Length.of(10, UnitOfLength.METER);
        Length second = Length.of(10, UnitOfLength.METER);
        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

}
