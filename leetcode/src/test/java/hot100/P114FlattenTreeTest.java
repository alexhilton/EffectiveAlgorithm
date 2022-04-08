package hot100;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P114FlattenTreeTest {
    @Test
    public void testFlattenTree() {
        Function<Integer[], Integer[]> action = a -> {
            TreeNode root = TreeNode.fromArray(a);
            System.out.println(Arrays.asList(a));
            TreeNode.preOrderPrint(root);
            P114FlattenTree.flattenTree(root);
            return TreeNode.toArray(root);
        };

        assertArrayEquals(new Integer[] {}, action.apply(new Integer[] {}));
        assertArrayEquals(new Integer[] {0}, action.apply(new Integer[] {0}));
        assertArrayEquals(new Integer[] {1, null, 2, null, 3, null, 4, null, 5, null, 6}, action.apply(new Integer[] {1, 2, 5, 3, 4, null, 6}));

        assertArrayEquals(new Integer[] {1, null, 2}, action.apply(new Integer[] {1, 2}));
        assertArrayEquals(new Integer[] {1, null, 2}, action.apply(new Integer[] {1, null, 2}));
        assertArrayEquals(new Integer[] {1, null, 2, null, 3}, action.apply(new Integer[] {1, 2, 3}));
        assertArrayEquals(new Integer[] {1, null, 3, null, 2}, action.apply(new Integer[] {1, 3, 2}));


    }
}
