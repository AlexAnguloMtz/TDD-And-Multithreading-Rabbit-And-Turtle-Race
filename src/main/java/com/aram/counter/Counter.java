package com.aram.counter;

import lombok.Getter;

@Getter
public class Counter {

    private int value;

    public void add(int value) {
        this.value += value;
    }

}
