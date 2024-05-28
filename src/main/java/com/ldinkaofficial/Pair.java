package com.ldinkaofficial;

import java.util.Objects;

public class Pair{
    public Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
    private int i;
    private int j;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setLocation(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return i == pair.i && j == pair.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
