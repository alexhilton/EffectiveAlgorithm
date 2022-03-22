package hot100;

// https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
public class P004FindMedian {

    // O(m+n)
    // Merge two sorted array into one, then find the median.
    // if m+n is odd, median = [(m+n)/2]
    // if even, median = ([(m+n)/2 - 1]+[(m+n)/2]) / 2.0
    // They ask algorithm to be O(log(m+n).
    // This is O(m+n), but why get accepted?
    public static double bruteForce(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    merged[k++] = nums1[i++];
                } else {
                    merged[k++] = nums2[j++];
                }
            } else if (j >= nums2.length) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        if ((merged.length & 0x01) == 0) {
            return ((double) merged[merged.length/2 - 1] + (double) merged[merged.length/2]) / 2.0d;
        }
        return merged[merged.length / 2];
    }

    // O((m+n/2)
    // double pointer from both ends.
    public static double doublePointer(int[] nums1, int[] nums2) {
        int li = 0;
        int lj = 0;
        int ri = nums1.length - 1;
        int rj = nums2.length - 1;
        int left = 0;
        int right = ri + rj;
        while (left++ < right--) {
            if (lj >= nums2.length || (li < nums1.length && nums1[li] <= nums2[lj])) {
                li++;
            } else {
                lj++;
            }

            if (rj < 0 || (ri >= 0 && nums1[ri] >= nums2[rj])) {
                ri--;
            } else {
                rj--;
            }
        }

        int leftItem;
        int rightItem;
        if (li == ri && lj == rj) {
            leftItem = nums1[li];
            rightItem = nums2[lj];
        } else if (li == ri) {
            leftItem = rightItem = nums1[li];
        } else if (lj == rj) {
            leftItem = rightItem = nums2[lj];
        } else {
            if (li >= nums1.length) {
                leftItem = nums2[lj];
            } else if (lj >= nums2.length) {
                leftItem = nums1[li];
            } else {
                leftItem = Math.min(nums1[li], nums2[lj]);
            }
            if (ri < 0) {
                rightItem = nums2[rj];
            } else if (rj < 0) {
                rightItem = nums1[ri];
            } else {
                rightItem = Math.max(nums1[ri], nums2[rj]);
            }
        }
        return ((double) leftItem + (double) rightItem) / 2.d;
    }
}
