package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P640SolveEquationTest {
    private P640SolveEquation instance;

    @BeforeEach
    public void setup() {
        instance = new P640SolveEquation();
    }

    @Test
    public void testDemos() {
        assertEquals("x=2", instance.solveEquation("x+5-3+x=6+x-2"));
        assertEquals("Infinite solutions", instance.solveEquation("x=x"));
        assertEquals("x=0", instance.solveEquation("2x=x"));
    }

    @Test
    public void testBasics() {
        assertEquals("No solution", instance.solveEquation("3=4"));
    }
}
