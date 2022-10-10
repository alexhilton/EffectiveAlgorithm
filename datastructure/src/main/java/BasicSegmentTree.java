
/**
 * Segment Tree
 * Basic version, support point update (PU) and region query (RU).
 * Underlying is an array with 4*n size, where n is the length of input array.
 */
public class BasicSegmentTree {
    private static final int BASE = 1;

    private final int[] tree;

    /**
     * The length of input array.
     */
    private final int size;

    /**
     * Instantiate the segment tree.
     * @param nums the input array.
     */
    public BasicSegmentTree(int[] nums) {
        size = nums.length;

        tree = new int[4 * size];

        build(nums, 0, size - 1, BASE);
    }

    /**
     * Replace item at k with val.
     * @param k the index to replace in input array.
     * @param val target value to replace with.
     */
    public void pointUpdate(int k, int val) {
        doPointUpdate(k, val, 0, size - 1, BASE);
    }

    /**
     * Get the region sum between [left, right] inclusive.
     * @param left the left index of the region in input array, inclusive.
     * @param right the right index of the region in input array, inclusive.
     * @return the region sum.
     */
    public int query(int left, int right) {
        return doQuery(left, right, 0, size - 1, BASE);
    }

    /**
     * Query the item at index of the input array.
     * @param index of the input array.
     * @return the item at index.
     */
    public int pointQuery(int index) {
        return doPointQuery(index, 0, size - 1, BASE);
    }

    private void build(int[] nums, int start, int end, int index) {
        if (start == end) {
            tree[index] = nums[start];
            return;
        }
        int mid = start + ((end - start) >> 1);
        build(nums, start, mid, 2 * index);
        build(nums, mid + 1, end, 2 * index + 1);
        pushUp(index);
    }

    private void pushUp(int index) {
        tree[index] = tree[2 * index] + tree[2 * index + 1];
    }

    private void doPointUpdate(int k, int val, int start, int end, int index) {
        if (start == end) {
            tree[index] = val;
            return;
        }
        int mid = start + ((end - start) >> 1);
        if (k <= mid) {
            doPointUpdate(k, val, start, mid, 2 * index);
        } else {
            doPointUpdate(k, val, mid + 1, end, 2 * index + 1);
        }
        pushUp(index);
    }

    /**
     * Get the sum of target region [left, right] starting from current region [start, end].
     * @param left target region left index, inclusive.
     * @param right target region right index, inclusive.
     * @param start current region left index, inclusive.
     * @param end current region right index, inclusive.
     * @param index current index of the segment tree.
     * @return the sum of target region.
     */
    private int doQuery(int left, int right, int start, int end, int index) {
        if (left <= start && end <= right) {
            return tree[index];
        }
        int sum = 0;
        int mid = start + ((end - start) >> 1);
        /*
         * Case #1: only need to query left half of current region.
         *         [left, right]
         *                       mid
         * Case #2: only need to query right half
         *                            [left, right]
         *                       mid
         * Case #3: query both left and right half
         *                [left,               right]
         *         [start         mid, mid+1           end]
         * Limitation: left <= right, start <= end
         * So, if left > mid, must have mid < left <= right, which is Case #2;
         * if right <= mid, must have left <= right <= mid, which is Case #1;
         * if left <= mid < right, which is Case #3.
         */
        if (left <= mid) {
            sum += doQuery(left, right, start, mid, 2 * index);
        }
        if (right > mid) {
            sum += doQuery(left, right, mid + 1, end, 2 * index + 1);
        }
        return sum;
    }

    private int doPointQuery(int where, int start, int end, int index) {
        if (start == end) {
            return tree[index];
        }
        int mid = start + ((end - start) >> 1);
        if (where <= mid) {
            return doPointQuery(where, start, mid, 2 * index);
        } else {
            return doPointQuery(where, mid + 1, end, 2 * index + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 11, 12, 13, 14};

        BasicSegmentTree bst = new BasicSegmentTree(a);

        System.out.println("60 = " + bst.query(0, 4));
        System.out.println("33 = " + bst.query(0, 2));
        System.out.println("36 = " + bst.query(1, 3));
        System.out.println("27 = " + bst.query(3, 4));

        bst.pointUpdate(2, 15);
        System.out.println("63 = " + bst.query(0, 4));
        System.out.println("36 = " + bst.query(0, 2));
        System.out.println("39 = " + bst.query(1, 3));
        System.out.println("27 = " + bst.query(3, 4));

        System.out.println("10 = " + bst.pointQuery(0));
        System.out.println("15 = " + bst.pointQuery(2));
        System.out.println("14 = " + bst.pointQuery(4));
    }
}
