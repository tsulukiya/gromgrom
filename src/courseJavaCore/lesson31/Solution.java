package courseJavaCore.lesson31;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Map<Character, Integer> countSymbols(String text) {
        Map<Character, Integer> result = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (result.containsKey(c)) {
                result.put(c, result.get(c) + 1);
            } else {
                result.put(c, 1);
            }

        }
        return result;
    }

    public Map<String, Integer> words(String text) {
        Map<String, Integer> result = new HashMap<>();

        for (String s : text.split(" ")) {
            if (isWord(s))
                if (result.containsKey(s)) {
                    result.put(s, result.get(s) + 1);
                } else {
                    result.put(s, 1);
                }
        }
        return result;
    }


    private boolean isWord(String word) {
        int count = 0;
        if (word.length() <= 2)
            return false;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c))
                count++;
        }
        return (count == word.length());
    }
}
