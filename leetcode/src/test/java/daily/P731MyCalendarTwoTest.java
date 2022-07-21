package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P731MyCalendarTwoTest {
    private P731MyCalendarTwo calendar;

    @BeforeEach
    public void setup() {
        calendar = new P731MyCalendarTwo();
    }

    @Test
    public void testBasics() {
        int[][] inputs = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        boolean[] expected = {true,true,true,false,true,true};
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i], calendar.book(inputs[i][0], inputs[i][1]));
        }
    }

    @Test
    public void testCase27() {
        int[][] inputs = {{5,12},{42,50},{4,9},{33,41},{2,7},{16,25},{7,16},{6,11},{13,18},{38,43},{49,50},{6,15},{5,13},{35,42},{19,24},{46,50},{39,44},{28,36},{28,37},{20,29},{41,49},{11,19},{41,46},{28,37},{17,23},{22,31},{4,10},{31,40},{4,12},{19,26}};
        boolean[] expected = {true,true,true,true,false,true,false,false,true,true,true,false,false,false,true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false};
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i], calendar.book(inputs[i][0], inputs[i][1]));
        }
    }
}