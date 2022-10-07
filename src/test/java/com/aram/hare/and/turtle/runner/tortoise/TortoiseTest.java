package com.aram.hare.and.turtle.runner.tortoise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TortoiseTest {

    @Test
    void test_getName() {
        Assertions.assertEquals("Tortoise", new Tortoise().getName());
    }

}
