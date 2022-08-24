package algo;

public class P977SortedSquares {
    public int[] sortedSquares(int[] nums) {
        final int n = nums.length;
        int left = 0;
        int right = n - 1;

        int[] result = new int[n];
        int index = n - 1;
        while (left <= right) {
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];
            if (a >= b) {
                result[index--] = a;
                left++;
            } else {
                result[index--] = b;
                right--;
            }
        }

        return result;
    }
}
