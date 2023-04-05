package cscd212classes.lab2;

import java.util.Objects;

public class Television {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(String model, boolean smart, int screenSize, int resolution, String make) {
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
    }

    public Television(String make, String model, boolean smart, int screenSize, int resolution,) {
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fourK, make, model, resolution, screenSize, smart);
    }

    @Override
    public String toString() {
        String str = make + '-' + model + ", " + screenSize + " inch " + resolution;
        return str;
    }
}

