package com.hillel.task20.model;

import java.util.Objects;
import java.util.UUID;

public final class City {
    private final String id;
    private final String name;

    public City(String name) {
        String idUUID = UUID.randomUUID().toString();
        this.id = idUUID.replaceAll("-", "");
        this.name = name;
    }

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getId().equals(city.getId()) &&
                getName().equals(city.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
