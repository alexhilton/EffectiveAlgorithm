package sorting;

import java.util.Arrays;

public class Sorting {
    public static int[] mergeSort(int[] nums) {
        int[] dst = Arrays.copyOf(nums, nums.length);
        mergeSortFunc(nums, dst, 0, nums.length);
        return dst;
    }

    private static void mergeSortFunc(int[] src, int[] dst, int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortFunc(dst, src, start, mid);
        mergeSortFunc(dst, src, mid, end);

        int i = start, j = mid, k = start;
        while (i < end || j < end) {
            if (j == end || (i < mid && src[i] < src[j])) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }
    }
}
