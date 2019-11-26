package com.github.mitschi.entities;

import java.io.Serializable;
import java.util.Objects;

public class Egg implements Serializable {

    private String id;
    private Boolean hasInnerPart;
    private String color;
    public Egg(){
        this.id="";
        this.hasInnerPart=true;
        this.color="natural";
    }
    public Egg(Boolean hasInnerPart, String color) {
        this.id="";
        this.hasInnerPart = hasInnerPart;
        this.color = color;
    }

    public Boolean getHasInnerPart() {
        return hasInnerPart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHasInnerPart(Boolean hasInnerPart) {
        this.hasInnerPart = hasInnerPart;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Egg egg = (Egg) o;
        return Objects.equals(id, egg.id) &&
                Objects.equals(hasInnerPart, egg.hasInnerPart) &&
                Objects.equals(color, egg.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hasInnerPart, color);
    }

    @Override
    public String toString() {
        return "Egg{" +
                "id='" + id + '\'' +
                ", hasInnerPart=" + hasInnerPart +
                ", color='" + color + '\'' +
                '}';
    }
}
