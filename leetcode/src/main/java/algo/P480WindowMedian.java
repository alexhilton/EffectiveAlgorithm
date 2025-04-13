package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P480WindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
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
            if (true||j == 307) {
                System.out.println("> i " + i + ", [i] " + nums[i] + ", left " + left + ", right " + right);
                System.out.println("> maxHeap -> " + maxHeap);
                System.out.println("> minHeap -> " + minHeap);
//                System.out.println("> maxHeap -> " + (maxHeap.isEmpty() ? maxHeap : maxHeap.peek()));
//                System.out.println("> minHeap -> " + (minHeap.isEmpty() ? minHeap : minHeap.peek()));
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
            if (true ||j == 307) {
                System.out.println("   after ins left " + left + ", right " + right);
                System.out.println("   after insertion maxHeap peek -> " + maxHeap);
                System.out.println("   after insertion minHeap peek -> " + minHeap);
//                System.out.println("   after insertion maxHeap peek -> " + maxHeap.peek());
//                System.out.println("   after insertion minHeap peek -> " + minHeap.peek());
            }
            if (k % 2 == 0) {
                ans[j] = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                ans[j] = maxHeap.peek();
            }
            int y = nums[i - k + 1];
            if (true||j == 307) {
                System.out.println(" Got #" + j + " ->" + ans[j] + ", y->" + y);
            }
            recycler.put(y, recycler.getOrDefault(y, 0) + 1);
            if (!minHeap.isEmpty() && y >= minHeap.peek()) {
                if (y == minHeap.peek()) {
                    prune(minHeap, recycler);
                }
                right--;
            } else if (y <= maxHeap.peek()) {
                if (y == maxHeap.peek()) {
                    prune(maxHeap, recycler);
                }
                left--;
            }
        }
        return ans;
    }

    private void prune(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int head = heap.peek();
            if (map.containsKey(head)) {
                map.put(head, map.get(head) - 1);
                if (map.get(head) == 0) {
                    map.remove(head);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }
}
