package pac20201126;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionReverceTest {

    SolutionReverse solution = new SolutionReverse();

    @Test
    public void testReverse_emptyString_returnsEmptyString(){
        assertEquals("", solution.reverce(""));
    }


    @Test
    public void testReverse2(){
        assertEquals("olleh", solution.reverce("hello"));
    }

    @Test
    public void testReverse3(){
        assertEquals("@ oL2leH", solution.reverce("Hel2Lo @"));
    }

}