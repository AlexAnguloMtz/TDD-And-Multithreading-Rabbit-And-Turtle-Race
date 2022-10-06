package com.aram.hare.and.turtle.turtle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TortoiseTest {

    @Test
    void test_getName() {
        assertEquals("Tortoise", new Tortoise().getName());
    }

}
