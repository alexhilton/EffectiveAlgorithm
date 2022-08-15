package tree;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static tree.TreeNode.*;

public class TreeTest {

    @Test
    public void testBasics() {
        Integer[] tree = null;
        TreeNode root = fromArray(tree);
        assertNull(root);
        assertArrayEquals(new Integer[] {null}, toArray(root));

        tree = new Integer[] {null};
        root = fromArray(tree);
        assertNull(root);
        assertArrayEquals(tree, toArray(root));

        tree = new Integer[] {1};
        root = fromArray(tree);
        assertNotNull(root);
        assertArrayEquals(tree, toArray(root));

        tree = new Integer[] {1, 2};
        root = fromArray(tree);
        assertNotNull(root);
        assertArrayEquals(tree, toArray(root));

        tree = new Integer[] {1, 2, 3};
        root = fromArray(tree);
        assertNotNull(root);
        assertArrayEquals(tree, toArray(root));

        tree = new Integer[] {3,9,20,null,null,15,7};
        root = fromArray(tree);
        assertNotNull(root);
        assertArrayEquals(tree, toArray(root));

        tree = new Integer[] {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        root = fromArray(tree);
        assertNotNull(root);
        assertArrayEquals(tree, toArray(root));

        tree = new Integer[] {1,2,2,3,4,4,3};
        root = fromArray(tree);
        assertNotNull(root);
        assertArrayEquals(tree, toArray(root));

        tree = new Integer[] {1,2,2,null,3,null,3};
        root = fromArray(tree);
        assertNotNull(root);
        assertArrayEquals(tree, toArray(root));
    }

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
        assertArrayEquals(new Integer[] {2, 3, 1}, action.apply(new Integer[] {1, 2, 3}));
    }
}
