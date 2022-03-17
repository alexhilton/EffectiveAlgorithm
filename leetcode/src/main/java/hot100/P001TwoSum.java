package hot100;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/two-sum/
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

    // Quadruple
    // Use binary search for both loops.
    public static int[] quadruple(int[] nums, int target) {
        int[] result = {0, 1};
        if (nums.length <= 2) {
            return result;
        }

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            if (nums[i] + nums[j] == target) {
                // Lucky
                result[0] = i;
                result[1] = j;
                return result;
            }

            // should be in [i+1, j-1], find them with double pointers.
            int x = target - nums[i];
            int y = target - nums[j];
            for (int k = i + 1, m = j - 1; k <= m; k++, m--) {
                result[0] = i;
                if (nums[k] == x) {
                    result[1] = k;
                    return result;
                } else if (nums[m] == x) {
                    result[1] = m;
                    return result;
                }

                result[1] = j;
                if (nums[k] == y) {
                    result[0] = k;
                    return result;
                } else if (nums[m] == y) {
                    result[0] = m;
                    return result;
                }
            }
        }

        return result;
    }

    // Binary search for loop, use hash to find target.
    // O(n/2) for the best case, provided Map is O(1)
    public static int[] binaryMap(int[] nums, int target) {
        int[] result = {0, 1};
        if (nums.length <= 2) {
            return result;
        }

        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (nums[i] + nums[j] == target) {
                // So lucky
                result[0] = i;
                result[1] = j;
                break;
            }
            int x = target - nums[i];
            if (valueToIndex.containsKey(x)) {
                result[0] = i;
                result[1] = valueToIndex.get(x);
                break;
            }
            x = target - nums[j];
            if (valueToIndex.containsKey(x)) {
                result[0] = j;
                result[1] = valueToIndex.get(x);
                break;
            }

            valueToIndex.put(nums[i], i);
            valueToIndex.put(nums[j], j);
        }

        return result;
    }
}