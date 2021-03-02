package hw202124_cut_and_set;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
2*. Есть словарь (Set<String>) - набор слов(маленькие буквы). Есть строка text.  Вернуть лист слов,
являющихся разбиением текста, если текст можно разбить на слова из словаря либо null

словарь: {hello, world, super}
text: hellosuper  -> {hello, super}
text: supersuper -> {super, super}
text: superhellosuper -> {super, hello, super}
text: superhelloo ->null *Текст должен полностью разбиваться на слова из словаря
(*есть решение через рекурсию и .startWith() )
 */
public class Dictionary {
    public List<String> getNewList(Set<String> dict, String text) {
        String curText = new String(text);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < dict.size(); i++) {
            for (String wort : dict) {
                if (curText.startsWith(wort)) {
                    res.add(wort);
                    curText = curText.substring(wort.length());
                }
            }
        }
        if (curText.length() > 0) {
            return null;
        }

        return res;
    }

//    public List<String> getNewList(Set<String> dict, String text) {
//        String curText = new String(text);
//        List<String> res = new ArrayList<>();
//        return req(dict, text, res);
//    }
//
//    private List<String> req(Set<String> dict, String cutText, List<String> res) {
//        String newText = "";
//        if (cutText.length()==0){
//            return res;
//        }
//        for (String wort : dict) {
//            if (newText.startsWith(wort)) {
//                res.add(wort);
//                req(dict, newText.substring(wort.length()), res);
//            }
//        }
//        return res;
//    }
}
