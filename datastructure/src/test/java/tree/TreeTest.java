package tree;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static tree.TreeNode.fromArray;
import static tree.TreeNode.postOrder;

public class TreeTest {

    @Test
    public void testPostOrder() {
        Function<Integer[], Integer[]> action = a -> {
            TreeNode root = fromArray(a);
            List<Integer> result = postOrder(root);
            return result.toArray(new Integer[0]);
        };

        assertArrayEquals(new Integer[] {}, action.apply(new Integer[] {}));
        assertArrayEquals(new Integer[] {0}, action.apply(new Integer[] {0}));
        assertArrayEquals(new Integer[] {1}, action.apply(new Integer[] {1}));

        assertArrayEquals(new Integer[] {2, 1}, action.apply(new Integer[] {1, 2}));
        assertArrayEquals(new Integer[] {2, 1}, action.apply(new Integer[] {1, null, 2}));
        assertArrayEquals(new Integer[] {3, 2, 1}, action.apply(new Integer[] {1, 2, 3}));
    }
}
