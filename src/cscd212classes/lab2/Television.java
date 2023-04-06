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
        if(model == null || make == null || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Bad parameters Television EVC");

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;

        if(resolution == 2160)
            fourK = true;
        else fourK = false;
    }

    public Television(String make, String model, boolean smart, int screenSize, int resolution) {
        if(model == null || make == null || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Bad parameters Television EVC");

        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;

        if(resolution == 2160)
            fourK = true;
        else fourK = false;
    }

    //look this over
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution
                && screenSize == that.screenSize && smart == that.smart
                && Objects.equals(make, that.make) && Objects.equals(model, that.model);
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

    //need to finish this
    @Override
    public int hashCode() {
        return Objects.hash(fourK, make, model, resolution, screenSize, smart);
    }

    //need to finish this
    @Override
    public String toString() {
        return make + '-' + model + ", " + screenSize + " inch " + resolution;
    }
}

