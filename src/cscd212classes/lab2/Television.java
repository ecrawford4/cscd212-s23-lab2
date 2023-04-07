package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(String model, boolean smart, int screenSize, int resolution, String make) {
        if(model == null || make == null || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;

        if(resolution == 2160)
            this.fourK = true;
        else this.fourK = false;
    }

    public Television(String make, String model, boolean smart, int screenSize, int resolution) {
        if(model == null || make == null || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;

        if(resolution == 2160)
            this.fourK = true;
        else this.fourK = false;
    }

    //need to FIX this
    @Override
    public int compareTo(Television another) {
        if (another == null) throw new IllegalArgumentException("null parameter in the compareTo method");

        if (this.make.compareTo(another.make) != 0) {
            if (this.model.compareTo(another.model) != 0) {
                return this.screenSize - another.screenSize;
            }
            return this.model.compareTo(another.model);
        }
        return this.make.compareTo(another.make);
    }

    //add this.
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
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getResolution() {
        return this.resolution;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    /**
     * The hashCode returns the value of the make hashCode from the String class
     *  + the value of the hashCode for the model from the String class
     *  + the resolution
     *  + the hashCode value of smart from the Boolean class
     *  + the hashCode of 4K from the Boolean class
     */
    @Override
    public int hashCode() {
        return (this.make.hashCode()
                + this.model.hashCode() + resolution
                + Boolean.hashCode(this.smart)
                + Boolean.hashCode(this.fourK));
    }
    /**
     * */
    @Override
    public String toString() {
        return this.make + '-' + this.model + ", " + this.screenSize + " inch " +
                ((this.smart)?"smart tv":"tv") + " with " +
                ((this.fourK)? "4K":this.resolution) + " resolution";
    }
}

