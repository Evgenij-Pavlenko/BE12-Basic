package pac20201209;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringPatternTest {

    StringPattern sp = new StringPattern();
    String text = "hello";

    @Test
    public void testIsPattern_helloAndHello_true() {
        String pattern = "hello";
        assertTrue(sp.isPattern(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndH_true() {
        String pattern = "h";
        assertTrue(sp.isPattern(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndO_true() {
        String pattern = "o";
        assertTrue(sp.isPattern(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndHo_true() {
        String pattern = "ho";
        assertTrue(sp.isPattern(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndOh_false() {
        String pattern = "oh";
        assertFalse(sp.isPattern(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndHll_true() {
        String pattern = "hll";
        assertTrue(sp.isPattern(text, pattern));
    }

    @Test
    public void testIsPattern_helloAndLlh_false() {
        String pattern = "llh";
        assertFalse(sp.isPattern(text, pattern));
    }

}
