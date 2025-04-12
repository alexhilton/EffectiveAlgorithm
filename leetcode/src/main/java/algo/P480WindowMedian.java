package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P480WindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        Map<Integer, Integer> recycler = new HashMap<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < k - 1; i++) {
            if (i < k / 2) {
                maxHeap.offer(nums[i]);
                left++;
            } else {
                long head = maxHeap.peek();
                if (nums[i] >= head && minHeap.size() < maxHeap.size()) {
                    minHeap.offer(nums[i]);
                    right++;
                } else {
                    minHeap.offer(maxHeap.poll());
                    right++;
                    maxHeap.offer(nums[i]);
                }
            }
        }

        for (int i = k - 1, j = 0; i < n; i++, j++) {
            if (j == 307) {
                System.out.println("> i " + i + ", [i] " + nums[i] + ", left " + left + ", right " + right);
                System.out.println("> maxHeap -> " + (maxHeap.isEmpty() ? maxHeap : maxHeap.peek()));
                System.out.println("> minHeap -> " + (minHeap.isEmpty() ? minHeap : minHeap.peek()));
            }
            int x = nums[i];
            if (left == right) {
                if (!minHeap.isEmpty() && x > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(x);
                    left++;
                } else {
                    maxHeap.offer(x);
                    left++;
                }
            } else if (left > right) {
                if (x >= maxHeap.peek()) {
                    minHeap.offer(x);
                    right++;
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(x);
                    right++;
                }
            } else {
                if (x <= minHeap.peek()) {
                    maxHeap.offer(x);
                    left++;
                } else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(x);
                    left++;
                }
            }
            // System.out.println("   after insertion maxHeap -> " + maxHeap);
            // System.out.println("   after insertion minHeap -> " + minHeap);
            if (j == 307) {
                System.out.println("   after ins left " + left + ", right " + right);
                System.out.println("   after insertion maxHeap peek -> " + maxHeap.peek());
                System.out.println("   after insertion minHeap peek -> " + minHeap.peek());
            }
            if (k % 2 == 0) {
                ans[j] = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                ans[j] = maxHeap.peek();
            }
            int y = nums[i - k + 1];
            if (j == 307) {
                System.out.println(" Got " + j + " ->" + ans[j] + ", y->" + y);
            }
            if (!minHeap.isEmpty() && y >= minHeap.peek()) {
                if (y == minHeap.peek()) {
                    minHeap.poll();
                } else {
                    recycler.put(y, recycler.getOrDefault(y, 0) + 1);
                }
                right--;
            } else if (y <= maxHeap.peek()) {
                if (y == maxHeap.peek()) {
                    maxHeap.poll();
                } else {
                    recycler.put(y, recycler.getOrDefault(y, 0) + 1);
                }
                left--;
            }
        }
        return ans;
    }
}
