package algo;

public class P153FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int left = mid == 0 ? nums.length - 1 : mid - 1;
            int right = mid == nums.length - 1 ? 0 : mid + 1;
            if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                return nums[mid];
            } else if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                return nums[right];
            } else if (nums[mid] > nums[left]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // should not be here.
    }
}
