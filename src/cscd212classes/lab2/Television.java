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

    /**
     * The compareTo method compares based on the make.
     * If the makes are the same then it compares based on the model.
     * If the models are the same it compares based on the screen size.
     */
    @Override
    public int compareTo(Television another) {
        if (another == null) throw new IllegalArgumentException("null parameter in the compareTo method");

        if (this.make.compareTo(another.make) == 0) {
            if (this.model.compareTo(another.model) == 0) {
                return this.screenSize - another.screenSize;
            }
            return this.model.compareTo(another.model);
        }
        return this.make.compareTo(another.make);
    }

    /**
     * The equals methods checks in this order
     * obj equal to this returns true
     * obj equal to null returns false
     * obj not an instance of Television returns false
     * All class variables must be exactly equal the variables of another.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return this.fourK == that.fourK && this.resolution == that.resolution
                && this.screenSize == that.screenSize && this.smart == that.smart
                && Objects.equals(this.make, that.make) && Objects.equals(this.model, that.model);
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
     * The toString method returns make-model, screen size inch
     * (smart if the resolution is 2160 otherwise empty string)
     * tv with (4K resolution or the tv resolution resolution)
     * No Smart or 4K Example: TCL-NS32R, 32 inch tv with 720 resolution
     * Smart and 4K Example: Samsung-SM85U, 85 inch smart tv with 4K resolution
     */
    @Override
    public String toString() {
        return this.make + '-' + this.model + ", " + this.screenSize + " inch " +
                ((this.smart)?"smart tv":"tv") + " with " +
                ((this.fourK)? "4K":this.resolution) + " resolution";
    }
}

