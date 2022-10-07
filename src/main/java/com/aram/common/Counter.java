package com.aram.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Counter implements Comparable<Counter> {

    private int value;

    private Counter(int value) {
        this.value = value;
    }

    public static Counter withZero() {
        return new Counter(0);
    }

    public static Counter withValue(int value) {
        return new Counter(value);
    }

    public Counter copy() {
        return Counter.withValue(getValue());
    }

    public boolean hasValue(int value) {
        return getValue() == value;
    }

    public void add(int value) {
        this.value += value;
    }

    public void add(Counter counter) {
        add(counter.getValue());
    }

    public void subtract(int value) {
        this.value -= value;
    }

    public void subtract(Counter counter) {
        subtract(counter.getValue());
    }

    @Override
    public int compareTo(Counter other) {
        return Integer.compare(value, other.getValue());
    }

}
