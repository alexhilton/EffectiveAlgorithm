import java.util.Arrays;

/**
 * The Binary Indexed Tree
 * Support point query (PQ) and range update (RU) in O(log^n) complexity.
 */
public class PQRUBIT {
    private int[] tree;
    private int size;

    public PQRUBIT(int[] nums) {
        int n = nums.length;
        System.out.println("original array: " + Arrays.toString(nums));
        size = n + 1;
        int[] diff = new int[n];
        tree = new int[size];

        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        System.out.println("diff array: " + Arrays.toString(diff));
        for (int i = 0; i < size - 1; i++) {
            add(i + 1, diff[i]);
        }
    }

    private void add(int i, int x) {
        for (int j = i; j < size; j += lowbit(j)) {
            tree[j] += x;
        }
    }

    private int lowbit(int i) {
        return i & -i;
    }

    public int query(int i) {
        int res = 0;
        for (int j = i + 1; j > 0; j -= lowbit(j)) {
            res += tree[j];
        }
        return res;
    }

    public void update(int l, int r, int x) {
        add(l + 1, x);
        add(r + 2, -x);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        PQRUBIT bit = new PQRUBIT(a);

        System.out.println("1 = " + bit.query(0));
        System.out.println("5 = " + bit.query(4));

        bit.update(2, 5, 3);
        System.out.println("1 = " + bit.query(0));
        System.out.println("6 = " + bit.query(2));
        System.out.println("8 = " + bit.query(4));
        System.out.println("9 = " + bit.query(5));
        System.out.println("7 = " + bit.query(6));
    }
}
