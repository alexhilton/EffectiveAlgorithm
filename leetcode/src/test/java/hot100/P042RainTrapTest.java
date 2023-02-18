package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P042RainTrapTest {
    private P042RainTrap instance;

    @BeforeEach
    public void setup() {
        instance = new P042RainTrap();
    }

    @Test
    public void testDemos() {
        assertEquals(6, instance.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(9, instance.trap(new int[] {4,2,0,3,2,5}));
    }
}
