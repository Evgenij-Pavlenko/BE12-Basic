package pac20210120;

import java.util.ArrayList;
import java.util.List;

/*
Задача:
Простым (prime) числом называется число, не имеющее делителей, кроме 1 и самого себя (кроме 1).
Написать метод, находящий все простные числа от 2 до N. List<Integer> getPrimes(int upperBound)
 */
public class PrimeNumber {

    List<Integer> getPrimes(int upperBound) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 2; i <= upperBound; i++) {
            if (isPrime(i)) {
                ret.add(i);
            }
        }
        return ret;
    }

//    private boolean isPrime(int i) {
//        int sqr = i/2;
//        for (int j = 2; j <= sqr; j++) {
//            if (i % j == 0) {
//                return false;
//            }
//        }
//        return true;
//    }

// count to the root of the number

    private boolean isPrime(int number) {
        int sqr = (int) Math.sqrt(number);
        for (int i = 2; i <= sqr; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
