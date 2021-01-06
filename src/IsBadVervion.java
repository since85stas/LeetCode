public class IsBadVervion {

    IsBadVervion() {
    }


    int size;
    int bad;

    private boolean isBadVersion(int n) {
        return n >= bad;
    }

    public void generateQuality(int size, int bad) {
        this.size = size;
        this.bad = bad;
    }

    public int firstBadVersion(int n) {
        if (n==1) {
            return n;
        }
        int nMin =0;
        int nMax = n;
        while (nMax-nMin>1) {
            int half = nMin + (nMax-nMin)/2;
            boolean isBad = isBadVersion(half);
            if (isBad) {
                nMax = half;
            } else {
                nMin = half;
            }
        }
        if (isBadVersion(nMin)) {
            return nMin;
        } else {
            return nMax;
        }
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);  12 ms */

    public class Solution2 {
        public int firstBadVersion(int n) {
            int start = 0;
            int end = n;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (isBadVersion(mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }

}


class VersionControl {

    private boolean[] quality;

    VersionControl(boolean[] quality) {
        this.quality = quality;
    }


}