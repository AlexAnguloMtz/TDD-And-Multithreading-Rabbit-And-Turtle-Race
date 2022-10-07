package com.aram.common;

import java.util.Collection;

public class Assert {

    public static void isGreater(Number tested, Number floor, String message) {
        if (!(tested.doubleValue() > floor.doubleValue())) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notBlank(String tested, String message) {
        if (tested == null || tested.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void isNotEmpty(Collection<T> elements, String message) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

}
