package com.aram.racing.assertions;

import com.aram.racing.core.runner.MovementStrategy;

import java.util.Collection;
import java.util.Set;

public class Assert {

    public static void IsGreater(Number tested, Number floor, String message) {
        if (!(tested.doubleValue() > floor.doubleValue())) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notBlank(String tested, String message) {
        if (tested == null || tested.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void IsNotEmpty(Collection<T> elements, String message) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}