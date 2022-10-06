package com.aram.probability.core;

import lombok.*;

@Data
public class Probability <T> {

    @NonNull
    private final T content;

    @NonNull
    private final Percentage percentage;

    public double getPercentage() {
        return percentage.getValue();
    }

}