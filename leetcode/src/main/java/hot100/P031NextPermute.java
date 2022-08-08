package hot100;

public class P031NextPermute {
    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return;
        }
        if (n == 2) {
            swap(nums, 0, 1);
            return;
        }

        int j = n - 1;
        while (j > 0 && nums[j - 1] >= nums[j]) {
            j--;
        }

        if (j > 1) {
            swap(nums, j - 1, j);
        } else if (j == 1) {
            if (nums[0] < nums[n - 1]) {
                int tmp = nums[n - 1];
                for (int i = n - 1; i > 0; i--) {
                    nums[i] = nums[i - 1];
                }
                nums[0] = tmp;
            } else {
                int tmp = nums[0];
                for (int i = 0; i < n - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[n - 1] = tmp;
            }

        } else {
            for (int i = 0, k = n - 1; i < k; i++, k--) {
                swap(nums, i, k);
            }
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
