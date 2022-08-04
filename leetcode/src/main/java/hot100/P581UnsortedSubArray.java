package hot100;

import java.util.Arrays;

public class P581UnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int left = 0;
        while (left < n - 1) {
            if (nums[left] > nums[left + 1]) {
                break;
            }
            left++;
        }
        if (left == n - 1) {
            return 0;
        }
        int right = n - 1;
        while (right > 0) {
            if (nums[right] < nums[right - 1]) {
                break;
            }
            right--;
        }
        if (right == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int i = left - 1;
        while (i >= 0 && nums[i] > min) {
            i--;
            left--;
        }
        int j = right + 1;
        while (j <= n - 1 && nums[j] < max) {
            j++;
            right++;
        }
        return right - left + 1;
    }
}
