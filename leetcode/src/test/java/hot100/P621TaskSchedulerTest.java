package hot100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P621TaskSchedulerTest {
    private P621TaskScheduler scheduler;

    @BeforeEach
    public void setup() {
        scheduler = new P621TaskScheduler();
    }

    @Test
    public void testBasics() {
        assertEquals(1, scheduler.leastInterval(new char[] {'A'}, 0));
        assertEquals(1, scheduler.leastInterval(new char[] {'B'}, 100));
    }

    @Test
    public void testDemos() {
        assertEquals(8, scheduler.leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
        assertEquals(6, scheduler.leastInterval(new char[] {'A','A','A','B','B','B'}, 0));
        assertEquals(16, scheduler.leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    @Test
    public void testCase17() {
        assertEquals(10, scheduler.leastInterval(new char[] {'A','B','C','D','E','A','B','C','D','E'}, 4));
    }
}
