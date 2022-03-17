package hot100;

public class P001TwoSum {
    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {};
    }

    // Binary search with double pointers from both end.
    public static int[] betterBruteForce(int[] nums, int target) {
        int[] result = {0, 1};
        if (nums.length <= 2) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            result[0] = i;
            int x = target - nums[i];
            for (int j = i + 1, k = nums.length - 1; j <= k; j++, k--) {
                if (nums[j] == x) {
                    result[1] = j;
                    return result;
                }
                if (nums[k] == x) {
                    result[1] = k;
                    return result;
                }
            }
        }

        return result;
    }
}