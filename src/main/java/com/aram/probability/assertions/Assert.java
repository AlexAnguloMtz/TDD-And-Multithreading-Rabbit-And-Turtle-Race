package com.aram.probability.assertions;

public class Assert {

    public static void isGreater(Number tested, Number floor, String message) {
        if (!(tested.doubleValue() > floor.doubleValue())) {
            throw new IllegalArgumentException(message);
        }
    }

}
