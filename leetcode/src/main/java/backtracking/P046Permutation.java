package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P046Permutation {
    private List<List<Integer>> result;
    private LinkedList<Integer> permutation;
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        permutation = new LinkedList<>();
        visited = new boolean[nums.length];

        doPermute(nums);

        return result;
    }

    private void doPermute(int[] nums) {
        System.out.println("P-> " + permutation);
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            doPermute(nums);
            permutation.removeLast();
            visited[i] = false;
        }
    }
}
