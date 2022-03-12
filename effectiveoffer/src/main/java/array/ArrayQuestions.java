package array;

import java.util.*;

public class ArrayQuestions {
    private static int[][] sums;

    public static void prepareSums(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }

    // Question 12
    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum - nums[i] == total - sum) {
                return i;
            }
        }
        return -1;
    }

    // Question 11
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return maxLength;
    }

    // Question 10
    public static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int n : nums) {
            sum += n;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Question 9
    public static int numSubArrayProductLessThanK(int[] nums, int k) {
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
    // O(n)
    // Best case is O(n): K is always bigger than sum, never into inner loop, result is 0.
    // Worst case is O(n+n): sum of [0, length-2] less than K, but last element bigger than K
    // left is still 0, when right is at end of array, must iterate left to end of array, too.
    public static int minSubArrayLen(int k, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        // To find min sub length, must iterate whole loop
        // So the end condition of loop invariant is when
        // right reach end of the array.
        for (int right = 0; right < nums.length; right++) {
            // sum holding the sum of [left, right]
            // move right to make sum bigger
            sum += nums[right];
            // move left to make sum smaller
            // Always move left when possible, even loop N times, but the total loop of left is from 0 to N-1
            // Which is the worst case.
            // no overlap of the two loops, which is the essence of this algorithm.
            while (left <= right && sum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                // when move left, kick the elements out of sum, the sum will be the sum of [left, right]
                // no need to calculate again.
                // This is another trick of this algorithm.
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
                // twoSum will return same tuple for all numbers equal to nums[i]
                // so skip all same values.
                // If not found, means nums[i] never be a tuple, also need to skip
                // all same values.
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

                // Found nums[j] and nums[k], all same nums[j] will return the same nums[k]
                // so need to skip same nums[j]
                // can skip all nums[k], of course.
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

    // Bruteforce, O(n^2)
    public static int[] twoSumBruteforce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        // Should not happen
        return new int[] {};
    }

    // Bruteforce with binary search
    // O(n*logn)
    public static int[] twoSumBinarySearch(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length;
            while (j < k) {
                int mid = (j + k) / 2;
                if (nums[i] + nums[mid] == target) {
                    return new int[] {i, mid};
                } else if (nums[i] + nums[mid] > target) {
                    k = mid - 1;
                } else {
                    j = mid + 1;
                }
            }
        }

        return new int[] {}; // Should not happen
    }

    // HashMap version
    // Generally O(n)
    public static int[] twosumHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int n : nums) {
            if (map.containsKey((target - n))) {
                return new int[] {map.get(n), map.get(target - n)};
            }
        }

        return new int[] {};
    }
}
