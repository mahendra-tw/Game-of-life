package com.tw.gameoflife;

import java.util.Objects;

public class Pair {
    private final int firstValue;
    private final int secondValue;

    public Pair(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public void printPairElements(){
        System.out.println(firstValue + ", " + secondValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return firstValue == pair.firstValue && secondValue == pair.secondValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue);
    }
}
