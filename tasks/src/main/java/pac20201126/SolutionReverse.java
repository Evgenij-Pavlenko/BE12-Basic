package pac20201126;

/**
 * The method reverses the text and then returns
 * @param text - the string to reverse
 * @return reversed text
 */
public class SolutionReverse {
    public String reverce(String text) {
        StringBuilder sb = new StringBuilder(text);
        return  sb.reverse().toString();
    }

}
