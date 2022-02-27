package array;

import sun.java2d.Disposer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayQuestions {
    // Question 9
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }

            count += right >= left ? right - left + 1 : 0;
        }
        return count;
    }

    // Question 8
    public static int minSubArrayLen(int k, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Question 7
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);

            int i = 0;
            while (i < nums.length - 2) {
                twoSumTuple(nums, i, result);
                int temp = nums[i];
                while (i < nums.length && nums[i] == temp) {
                    i++;
                }
            }
        }

        return result;
    }

    private static void twoSumTuple(int[] nums, int i, List<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                int temp = nums[j];
                while (nums[j] == temp && j < k) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }

    // Question 6
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[] {i, j};
    }
}
