public class BinarySearch {
    /**
     * Standard binary search.
     * @param arr Sorted in ascending order.
     * @param target
     * @return the index where [index] == target, or -1.
     */
    public int standardAsc(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Find first item which is bigger than or equals @param target.
     * This is equivalent to find last item which is less than target.
     * @param arr must be sorted in ascending order.
     * @param target
     * @return the first index bigger than target, or -1 if target > [n-1],
     * which means target is bigger than all elements.
     */
    public int firstBiggerAscV1(int[] arr, int target) {
        System.out.println("target -> " + target + ", len -> " + arr.length);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            StringBuilder sb = new StringBuilder();
            sb.append("arr = [");
            for (int i = 0; i < left; i++) {
                sb.append("  ,");
            }
            for (int i = left; i <= right; i++) {
                sb.append(String.format("%2d", arr[i]));
                sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);

            if (arr[mid] >= target) {
                right = mid;
                System.out.println("\t[mid] bigger than target, go left!");
            } else {
                left = mid + 1;
                System.out.println("\t[mid] less than target, go right!");
            }
        }
        System.out.println("left/right -> " + left + ", ans -> " + (arr[left] >= target ? left : -1));
        return arr[left] >= target ? left : -1;
    }

    /**
     * See {@link #firstBiggerAscV1}
     * @param arr
     * @param target
     * @return
     */
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


    /**
     * Find last item which is bigger than or equals to target.
     * This is equivalent to first item which is less than target.
     * @param arr Sorted in descending order.
     * @param target
     * @return last item which >= target or -1 if [0] < target, which
     * means target is bigger than all elements.
     */
    public int lastBiggerDscV1(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                if (mid == n - 1 || arr[mid + 1] < target) {
                    return mid;
                }
                left = mid + 1;
            } else {
                if (mid > 0 && arr[mid - 1] >= target) {
                    return mid - 1;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    public int lastBiggerDscV2(int[] arr, int target) {
        System.out.println("target -> " + target + ", len -> " + arr.length);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            StringBuilder sb = new StringBuilder();
            sb.append("arr = [");
            for (int i = 0; i < left; i++) {
                sb.append("  ,");
            }
            for (int i = left; i <= right; i++) {
                sb.append(String.format("%2d", arr[i]));
                sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);

            if (arr[mid] >= target) {
                left = mid;
                System.out.println("\t[mid] less than target, go right!");
            } else {
                right = mid - 1;
                System.out.println("\t[mid] bigger than target, go left!");
            }
        }
        System.out.println("left/right -> " + left + ", ans -> " + (arr[left] >= target ? left : -1));
        return arr[left] >= target ? left : -1;
    }
}
