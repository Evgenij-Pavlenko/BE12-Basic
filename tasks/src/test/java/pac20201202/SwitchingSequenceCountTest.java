package pac20201202;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// {1,2,3,4,5} -> 2 (1,2)
//         * {1,2,3,4,5,4} -> 3 (4,5,4)
//         * {5} -> 1
//         * {} -> 0
class SwitchingSequenceCountTest {
    SwitchingSequenceCount sequence = new SwitchingSequenceCount();

    //{1,2,3,4,5} -> 2 (1,2)
    @Test
    public void testCheckSequence_seq1_2() {
        int[] arr = {1, 2, 3, 4, 5};
        int actual = sequence.checkSequenceCount(arr);
        assertEquals(2, actual);
    }

    //{1,2,3,4,5,4} -> 3 (4,5,4)
    @Test
    public void testCheckSequence_seq2_3() {
        int[] arr = {1, 2, 3, 4, 5, 4};
        int actual = sequence.checkSequenceCount(arr);
        assertEquals(3, actual);
    }

    //{5} -> 1
    @Test
    public void testCheckSequence_seqOne_1() {
        int[] arr = {5};
        int actual = sequence.checkSequenceCount(arr);
        assertEquals(1, actual);
    }

    //{} -> 0
    @Test
    public void testCheckSequence_seqNull_0() {
        int[] arr = {};
        int actual = sequence.checkSequenceCount(arr);
        assertEquals(0, actual);
    }
    //{1,2,3,4,5,4,1} -> 3 (4,5,4)
    @Test
    public void testCheckSequence_seq3_3() {
        int[] arr = {1, 2, 3, 4, 5, 4, 1};
        int actual = sequence.checkSequenceCount(arr);
        assertEquals(3, actual);
    }

}
