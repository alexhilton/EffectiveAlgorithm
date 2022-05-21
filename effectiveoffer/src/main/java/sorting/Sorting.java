package sorting;

import java.util.Arrays;

public class Sorting {

    public static int[] iteratedMergeSort(int[] nums) {
        int length = nums.length;
        int[] src = nums;
        int[] dst = new int[length];
        for (int seg = 1; seg < length; seg += seg) {
            for (int start = 0; start < length; start += seg * 2) {
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);
                // start merging
                int i = start, j = mid, k = start;
                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }
            }

            // the result (sorted array) is stored in dst
            // we need to resume sorting from previously result
            // so next loop need to start from dst
            // thus, need to swap src and dst.
            int[] temp = src;
            src = dst;
            dst = temp;
        }

        return src;
    }

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
        // swap the src and dst
        mergeSortFunc(dst, src, start, mid);
        mergeSortFunc(dst, src, mid, end);

        // merge the final result
        int i = start, j = mid, k = start;
        while (i < mid || j < end) {
            if (j == end || (i < mid && src[i] < src[j])) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }
    }
}
