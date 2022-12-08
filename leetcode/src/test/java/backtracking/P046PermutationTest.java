package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P046PermutationTest {
    private P046Permutation instance;

    @BeforeEach
    public void setup() {
        instance = new P046Permutation();
    }

    @Test
    public void testDemos() {
        instance.permute(new int[] {1, 2, 3});
        instance.permute(new int[] {0, 1});
        instance.permute(new int[] {1});
    }
}
