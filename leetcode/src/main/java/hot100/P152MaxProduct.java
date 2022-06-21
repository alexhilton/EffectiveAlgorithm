package hot100;

public class P152MaxProduct {
    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ppp = 1;
        int pp = nums[0];
        int result = pp;
        int seq;
        for (int i = 1; i < nums.length; i++) {
            int pseq = Math.max(ppp * nums[i - 1] * nums[i], pp * nums[i]);
            int sseq = Math.max(nums[i], nums[i] * nums[i - 1]);
            seq = Math.max(pseq, sseq);
            result = Math.max(result, seq);
            ppp = pp;
            pp = seq;
        }

        return result;
    }
}
