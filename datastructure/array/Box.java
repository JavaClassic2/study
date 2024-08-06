package com.nhnacademy;

public class Box {
    int value;

    public Box(int value) {
        this.value = value;
    }

    public void up() {
        value++;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Box) && (((Box) o).value == value);
    }

    @Override
    public String toString() {
        return value+"";
    }
}