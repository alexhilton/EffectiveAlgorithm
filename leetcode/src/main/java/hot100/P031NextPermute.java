package hot100;

public class P031NextPermute {
    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        int j = n - 2;
        while (j >= 0 && nums[j] >= nums[j + 1]) {
            j--;
        }
        if (j >= 0) {
            int k = n - 1;
            while (k > j && nums[k] <= nums[j]) {
                k--;
            }
            swap(nums, j, k);
        }
        // reverse [j + 1, n - 1]
        for (int i = j + 1, k = n - 1; i < k; i++, k--) {
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
