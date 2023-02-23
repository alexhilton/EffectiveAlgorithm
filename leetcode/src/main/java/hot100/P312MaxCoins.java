package hot100;

import java.util.PriorityQueue;

public class P312MaxCoins {
    public int maxCoins(int[] nums) {
        final int n = nums.length;
        // all zeros first
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int answer = 0;
        int left = 0;
        while (left < n && nums[left] == -1) {
            left++;
        }
        int right = n - 1;
        while (right >= 0 && nums[right] == -1) {
            right--;
        }
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return nums[left];
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        for (int i = left + 1; i < right; i++) {
            if (nums[i] != -1) {
                minHeap.offer(i);
            }
        }
        while (!minHeap.isEmpty()) {
            int p = minHeap.poll();
            answer += coin(nums, p, left, right);
        }
        answer += Math.max(nums[left], nums[right]);
        answer += nums[left] * nums[right];

        return answer;
    }

    private int coin(int[] nums, int p, int left, int right) {
        if (nums[p] == 0) {
            return 0;
        }
        int a = nums[p];
        int i = p - 1;
        while (i >= left && nums[i] == -1) {
            i--;
        }
        if (i >= left) {
            a *= nums[i];
        }
        int j = p + 1;
        while (j <= right && nums[j] == -1) {
            j++;
        }
        if (j <= right) {
            a *= nums[j];
        }
        nums[p] = -1;
        return a;
    }
}
