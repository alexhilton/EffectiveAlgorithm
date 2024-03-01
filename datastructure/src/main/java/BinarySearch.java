public class BinarySearch {
    /**
     * Find first item which bigger than @param target.
     * @param arr must be sorted in ascending order.
     * @param target
     * @return the first index bigger than target, or -1 if target is bigger than all elements.
     */
    public int firstBiggerAscV1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left] >= target ? left : -1;
    }

    public int firstBiggerAscV2(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        // if need to return in loop, should use <=
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                if (mid < n - 1 && arr[mid + 1] >= target) {
                    return mid + 1;
                }
                left = mid + 1;
            }
        }

        return -1;
    }
}
