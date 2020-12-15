package pac20201209;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * text, pattern состоят только из маленьких букв латинского алфавита
 * Является ли паттерн подпоследовательностью text'a?
 * hello:
 * elo -> true
 * lo -> true
 * he -> true
 * hll -> true
 * llh -> false
 */
public class StringPattern {

//    public boolean isPattern(String text, String pattern) {
//        boolean flag = false;
//        if (pattern.length() == 0) {
//            flag = true;
//            return flag;
//        } else if (text.length() == 0 && pattern.length() != 0) {
//            return flag;
//        }
//        int lastIndexText = text.length()-1;
//        int lastIndexPattern = pattern.length()-1;
//        if (text.charAt(lastIndexText) == pattern.charAt(lastIndexPattern)) {
//            isPattern(text.substring(0, lastIndexText), pattern.substring(0, lastIndexPattern));
//        } else {
//            isPattern(text.substring(0, lastIndexText), pattern);
//        }
//        return flag;
//    }

    public boolean isPattern(String text, String pattern) {
        int lastIndexText = text.length() - 1;
        int lastIndexPattern = pattern.length() - 1;
        for (int i = lastIndexText; i >= 0; i--) {
            if (text.charAt(i) == pattern.charAt(lastIndexPattern)) {
                pattern = pattern.substring(0, lastIndexPattern);
                lastIndexPattern--;
            }
            if (pattern.length() == 0) {
                return true;
            }
        }
        return false;
    }

}
