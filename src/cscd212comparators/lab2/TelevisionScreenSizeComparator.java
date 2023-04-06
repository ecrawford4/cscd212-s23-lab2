package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

public class TelevisionScreenSizeComparator {
    public int compare(final Television t1, final Television t2) {
        return Integer.compare(t1.getScreenSize(),t2.getScreenSize());
    }
}
