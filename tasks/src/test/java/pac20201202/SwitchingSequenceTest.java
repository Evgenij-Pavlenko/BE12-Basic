package pac20201202;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SwitchingSequenceTest {
    SwitchingSequence sequence = new SwitchingSequence();

    //{5,-3,5,-3,5} -> true
    @Test
    public void testCheckSequence_seqOdd_true() {
        List<Integer> list = Arrays.asList(5, -3, 5, -3, 5);
        boolean actual = sequence.checkSequence(list);
        assertTrue(actual);
    }

    //{5,-3,5,-3,5,-3} -> true
    @Test
    public void testCheckSequence_seqEven_true() {
        List<Integer> list = Arrays.asList(5, -3, 5, -3, 5, -3);
        boolean actual = sequence.checkSequence(list);
        assertTrue(actual);
    }

    //{5,-3} -> true
    @Test
    public void testCheckSequence_seq2_true() {
        List<Integer> list = Arrays.asList(5, -3);
        boolean actual = sequence.checkSequence(list);
        assertTrue(actual);
    }

    //{5} -> true
    @Test
    public void testCheckSequence_seq1_true() {
        List<Integer> list = Arrays.asList(5);
        boolean actual = sequence.checkSequence(list);
        assertTrue(actual);
    }

    //{5,-3,1,-3,5} -> false
    @Test
    public void testCheckSequence_seq_false() {
        List<Integer> list = Arrays.asList(5, -3, 1, -3, 5);
        boolean actual = sequence.checkSequence(list);
        assertFalse(actual);
    }

    //{5,-3,1,1,5} -> false
    @Test
    public void testCheckSequence_seq2_false() {
        List<Integer> list = Arrays.asList(5, -3, 1, 1, 5);
        boolean actual = sequence.checkSequence(list);
        assertFalse(actual);
    }
}
