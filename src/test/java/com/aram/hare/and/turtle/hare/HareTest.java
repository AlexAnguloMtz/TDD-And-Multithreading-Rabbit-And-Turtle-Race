package com.aram.hare.and.turtle.hare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HareTest {

    @Test
    void test_getName() {
        assertEquals("Hare", new Hare().getName());
    }

}
