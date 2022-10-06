package com.aram.probability.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Percentage {

    private final double value;

    private Percentage(double value) {
        validate(value);
        this.value = value;
    }

    public static Percentage of(double value) {
        return new Percentage(value);
    }

    public static boolean isValid(double value) {
        return Range.isBetween(0, 100, value);
    }

    private void validate(double value) {
        if (!isValid(value)) {
            throw new IllegalPercentageException("%d is not a valid percentage");
        }
    }

}
