package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

public class TelevisionResolutionMakeDescendingComparator {
    public int compare(Television t1, Television t2) {
        if(Integer.compare(t1.getResolution(),t2.getResolution()) != 0)
            return t1.getMake().compareTo(t2.getMake());
        return Integer.compare(t1.getResolution(),t2.getResolution());
    }
}
