package algo;

import java.awt.font.NumericShaper;

public class P153FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid == 0) {
                if (nums[mid] < nums[mid + 1]) {
                    return nums[mid];
                } else {
                    return nums[mid + 1];
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return nums[mid - 1];
                } else {
                    return nums[mid];
                }
            } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] > nums[left] && nums[mid] < nums[right]) {
                return nums[left];
            } else if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // should not be here.
    }
}
