package pac20201202;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MaxQuantityTest {
    MaxQuantity maxQuantity = new MaxQuantity();

    //{1,2,3,4,5} -> 1
    @Test
    public void testMaxQuantity_any_first1(){
        int[] arr = {1,2,3,4,5};
        int actual = maxQuantity.maxQuantity(arr);
        assertEquals(1, actual);
    }
    //{5,4,3,2,1} -> 1  ====>> worked only with LinkedHashMap
    @Test
    public void testMaxQuantity_any_first5(){
        int[] arr = {5,4,3,2,1};
        int actual = maxQuantity.maxQuantity(arr);
        assertEquals(5, actual);
    }

    //{5} -> 5
    @Test
    public void testMaxQuantity_oneNumber_oneNumber(){
        int[] arr = {5};
        int actual = maxQuantity.maxQuantity(arr);
        assertEquals(5, actual);
    }

    //{1,2,3,4,5,3,5} -> 3
    @Test
    public void testMaxQuantity_any_3(){
        int[] arr = {1,2,3,4,5,3,5};
        int actual = maxQuantity.maxQuantity(arr);
        assertEquals(3, actual);
    }

    //{3,3,3,3,3} -> 3
    @Test
    public void testMaxQuantity_all3_3(){
        int[] arr = {3,3,3,3,3};
        int actual = maxQuantity.maxQuantity(arr);
        assertEquals(3, actual);
    }

}
