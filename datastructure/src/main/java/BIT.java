/**
 * The Binary Indexed Tree.
 * Support point update (PU) and range query (RQ) in O(log^n) complexity.
 */
public class BIT {
    // The original array, which is not really necessary.
    private int[] nums;

    // the size of the Binary Indexed array, size = n + 1, n is the length of original array.
    private int size;

    // The Binary Indexed Array, valid data are in [1, size), where size = n + 1
    // Original array element [i] is mapped to [i + 1] in the tree.
    private int[] tree;

    public BIT(int[] nums) {
        this.nums = nums;
        size = nums.length + 1;

        tree = new int[size];
        for (int i = 0; i < size - 1; i++) {
            add(i + 1, nums[i]);
        }
    }

    private static int lowbit(int i) {
        return i & -i;
    }

    // Update array element [i] to val
    // Meaning set nums[i] to val, but it is easier to maintain tree with delta
    // nums[i] = val, is the same to nums[i] = nums[i] + (val - nums[i]), where val - nums[i]
    // is the delta.
    // So we add affected items in tree with the delta.
    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    private void add(int i, int x) {
        for (int j = i; j < size; j += lowbit(j)) {
            tree[j] += x;
        }
    }

    // Query the regional sum in [l, r]
    public int query(int l, int r) {
        return preSum(r + 1) - preSum(l);
    }

    // Get the preSum up to i inclusive.
    private int preSum(int i) {
        int sum = 0;
        for (int j = i; j > 0; j -= lowbit(j)) {
            sum += tree[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BIT bit = new BIT(a);

        System.out.println("3 = " + bit.query(0, 1));
        System.out.println("18 = " + bit.query(2, 5));

        bit.update(3, 5);
        System.out.println("3 = " + bit.query(0, 1));
        System.out.println("19 = " + bit.query(2, 5));
    }
}
