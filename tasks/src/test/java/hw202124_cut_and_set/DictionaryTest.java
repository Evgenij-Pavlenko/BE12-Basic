package hw202124_cut_and_set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
словарь: {hello, world, super}
text: hellosuper  -> {hello, super}
text: supersuper -> {super, super}
text: superhellosuper -> {super, hello, super}
text: superhelloo ->null *Текст должен полностью разбиваться на слова из словаря
(*есть решение через рекурсию и .startWith(
 */
class DictionaryTest {
    Dictionary dictionary = new Dictionary();

    Set<String> dic = new HashSet<>();
    @BeforeEach
    public void createDictionary(){
        dic.add("hello");
        dic.add("world");
        dic.add("super");
    }

    @Test
    public void testGetNewList_hellosuper_true(){
        List<String> actual = dictionary.getNewList(dic, "hellosuper");
        List<String> expected = Arrays.asList("hello", "super");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNewList_supersuper_true(){
        List<String> actual = dictionary.getNewList(dic, "supersuper");
        List<String> expected = Arrays.asList("super", "super");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNewList_superhellosuper_true(){
        List<String> actual = dictionary.getNewList(dic, "superhellosuper");
        List<String> expected = Arrays.asList("super", "hello", "super");
        assertEquals(expected, actual);
    }


    @Test
    public void testGetNewList_superhelloo_null(){
        List<String> actual = dictionary.getNewList(dic, "superhelloo");
        List<String> expected = new ArrayList<>();
        assertEquals(null, actual);
    }

    //fall
    @Test
    public void testGetNewList_superhelloo9_null(){
        dic.clear();
        dic.add("hell");
        dic.add("hello");
        dic.add("ole");

        List<String> actual = dictionary.getNewList(dic, "hellole");
        List<String> expected = Arrays.asList("hell", "ole");
        assertEquals(expected, actual);
    }



}
