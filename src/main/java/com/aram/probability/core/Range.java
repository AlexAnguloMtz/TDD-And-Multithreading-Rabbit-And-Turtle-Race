package com.aram.probability.core;

import com.aram.probability.assertions.Assert;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static java.lang.String.format;

@Getter
@EqualsAndHashCode
@ToString
public class Range {

    private final double floor;
    private final double ceiling;

    private Range(double floor, double ceiling) {
        Assert.isGreater(ceiling, floor, format(
            "Cannot create instance if ceiling %f is not greater than floor %f", ceiling, floor));
        this.floor = floor;
        this.ceiling = ceiling;
    }

    public static boolean isBetween(Number floor, Number ceiling, Number tested) {
        return tested.doubleValue() >= floor.doubleValue() &&
               tested.doubleValue() <= ceiling.doubleValue();
    }

    public static Range of(double floor, double ceiling) {
        return new Range(floor, ceiling);
    }

    public boolean contains(double value) {
        return isBetween(floor, ceiling, value);
    }

    public double random() {
        return (Math.random() * (ceiling - floor)) + floor;
    }

}