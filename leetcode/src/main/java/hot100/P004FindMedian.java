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
}
