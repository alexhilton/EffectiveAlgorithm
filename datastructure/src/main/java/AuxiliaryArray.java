import javax.xml.transform.stax.StAXResult;

public class AuxiliaryArray {
    private int[] nums;
    private int[] preSum;

    private int size;

    public AuxiliaryArray(int[] nums) {
        this.nums = nums;
        size = nums.length;
        preSum = new int[size];
        init();
    }

    private void init() {
        if (size < 1) {
            return;
        }
        preSum[0] = nums[0];

        for (int i = 1; i < size; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    private int regionSum(int i, int j) {
        if (i == 0) {
            return preSum[j];
        }
        return preSum[j] - preSum[i - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AuxiliaryArray aa = new AuxiliaryArray(arr);
        System.out.println(aa.regionSum(0, 0));
        System.out.println(aa.regionSum(0, 1));
        System.out.println(aa.regionSum(1, 2));
        System.out.println(aa.regionSum(3, 7));
    }
}
