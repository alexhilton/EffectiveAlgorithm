/**
 * The Binary Indexed Tree
 * Support range query (RQ) and range update (RU) in O(log^n) complexity.
 */
public class RQRUBIT {
    private int size;
    private int[] tree;
    private int[] conTree;

    public RQRUBIT(int[] nums) {
        final int n = nums.length;
        size = n + 1;

        int[] diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        tree = new int[size];
        for (int i = 0; i < n; i++) {
            add(tree, i + 1, diff[i]);
        }

        conTree = new int[size];
        for (int i = 0; i < n; i++) {
            add(conTree, i + 1, i * diff[i]);
        }
    }

    public int rangeQuery(int l, int r) {
        int preSumL = l * query(tree, l) - query(conTree, l);
        int preSumR = (r + 1) * query(tree, r + 1) - query(conTree, r + 1);
        return preSumR - preSumL;
    }

    public void rangeUpdate(int l, int r, int x) {
        add(tree, l + 1, x);
        add(tree, r + 2, -x);

        add(conTree, l + 1, l * x);
        add(conTree, r + 2, (r + 1) * -x);
    }

    private void add(int[] t, int i, int x) {
        for (int j = i; j < size; j += lowbit(j)) {
            t[j] += x;
        }
    }

    private int query(int[] t, int k) {
        int res = 0;
        for (int j = k; j > 0; j -= lowbit(j)) {
            res += t[j];
        }
        return res;
    }

    private int lowbit(int i) {
        return i & -i;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RQRUBIT bit = new RQRUBIT(a);

        System.out.println("3 = " + bit.rangeQuery(0, 1));
        System.out.println("18 = " + bit.rangeQuery(2, 5));

        bit.rangeUpdate(3, 6, 3);
        System.out.println("3 = " + bit.rangeQuery(0, 1));
        System.out.println("27 = " + bit.rangeQuery(2, 5));
        System.out.println("10 = " + bit.rangeQuery(2, 3));
    }
}
