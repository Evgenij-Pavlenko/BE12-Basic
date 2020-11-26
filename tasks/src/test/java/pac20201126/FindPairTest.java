package pac20201126;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 *  {3, 5, 3}->5; {3,5,3,3,3}->5; {3,5,3,5,3}->3
 */
import static org.junit.jupiter.api.Assertions.*;

class FindPairTest {

    FindPair findPair = new FindPair();

    @Test
    public void setFindPair_listInteger_5() {
        List<Integer> accept = Arrays.asList(3, 5, 3);
        assertEquals(5, findPair.findPair(accept));
    }

    @Test
    public void setFindPair_bigListInteger_5() {
        List<Integer> accept = Arrays.asList(3, 5, 3, 3, 3);
        assertEquals(5, findPair.findPair(accept));
    }

    @Test
    public void setFindPair_listIntegerWith3_() {
        List<Integer> accept = Arrays.asList(3, 5, 3, 5, 3);
        assertEquals(3, findPair.findPair(accept));
    }

}