package com.aram.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CounterTest {

    @Test
    void test_has_value() {
        Counter positive = Counter.withValue(20);
        assertTrue(positive.hasValue(20));
        assertFalse(positive.hasValue(100));

        Counter negative = Counter.withValue( - 20 );
        assertTrue(negative.hasValue( - 20 ));
        assertFalse(negative.hasValue( - 100 ));
    }

    @Test
    void default_factory_method_returns_a_counter_with_value_equal_to_zero() {
        Counter counter = Counter.withZero();
        assertTrue(counter.hasValue(0));
    }

    @Test
    void test_add() {
        Counter counter = Counter.withZero();
        counter.add(987654321);
        assertTrue(counter.hasValue(987654321));
    }

    @Test
    void test_subtract() {
        Counter counter = Counter.withZero();
        counter.subtract(987654321);
        assertTrue(counter.hasValue( - 987654321 ));
    }

    @Test
    void two_instances_are_equal_if_they_contain_the_same_value() {
        Counter first = Counter.withZero();
        Counter second = Counter.withZero();
        first.add(5);
        second.add(5);
        assertEquals(first, second);
    }

    @Test
    void two_instances_are_not_equal_if_they_contain_different_values() {
        Counter first = Counter.withZero();
        Counter second = Counter.withZero();
        first.add(5);
        second.add(15);
        assertNotEquals(first, second);
    }

    @Test
    void equals_and_hash_code_are_symmetric() {
        Counter first = Counter.withZero();
        Counter second = Counter.withZero();
        first.add(5);
        second.add(5);
        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void can_receive_another_instance_and_add_its_value() {
        Counter first = Counter.withZero();
        Counter second = Counter.withZero();
        first.add(5);
        second.add(first);
        assertTrue(second.hasValue(5));
    }

    @Test
    void can_receive_another_instance_and_subtract_its_value() {
        Counter first = Counter.withZero();
        Counter second = Counter.withZero();
        first.add(5);
        second.subtract(first);
        assertTrue(second.hasValue( - 5 ));
    }

    @Test
    void test_parameterized_static_factory_method() {
        Counter counter = Counter.withValue(5);
        assertTrue(counter.hasValue(5));
    }

    @Test
    void test_compare() {
        Counter first = Counter.withValue(5);
        Counter second = Counter.withValue(10);
        int firstComparison = second.compareTo(first);
        assertTrue(0 < firstComparison);

        Counter third = Counter.withValue(10);
        Counter fourth = Counter.withValue(15);
        int secondComparison = third.compareTo(fourth);
        assertTrue(secondComparison < 0);
    }

    @Test
    void test_copy() {
        Counter original = Counter.withValue(20);
        Counter copy = original.copy();
        assertTrue(copy.hasValue(20));
    }

}
