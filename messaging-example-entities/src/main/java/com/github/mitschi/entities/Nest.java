package com.github.mitschi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Nest implements Serializable {
    private List<Egg> eggs;

    public Nest(){
        this.eggs = new ArrayList<>();
    }
    public Nest(List<Egg> eggs) {
        this.eggs = eggs;
    }

    public List<Egg> getEggs() {
        return eggs;
    }

    public void setEggs(List<Egg> eggs) {
        this.eggs = eggs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nest nest = (Nest) o;
        return Objects.equals(eggs, nest.eggs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eggs);
    }

    @Override
    public String toString() {
        return "Nest{" +
                "eggs=" + eggs +
                '}';
    }
}
