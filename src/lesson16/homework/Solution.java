package lesson16.homework;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        //String test = "First program in JAVA";
        String test = "";

        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));


    }

    public static int countWords(String input) {
        int count = 0;
        int count1;

        String[] mas = input.split(" ");

        for (String ma : mas) {
            count1 = 0;
            for (char c : ma.toCharArray()) {
                if (Character.isLetter(c))
                    count1++;
                if (count1 == ma.toCharArray().length)
                    count++;
            }

        }

        return count;
    }

    public static String maxWord(String input) {

        String[] mas = input.split(" ");
        String maxWord = isWord(input);

        if (maxWord != null && (countWords(input) != 0)) {


            for (String ma : mas) {
                int count = 0;
                for (char c : ma.toCharArray()) {
                    if (Character.isLetter(c))
                        count++;
                    if (count == ma.toCharArray().length &&
                            ma.toCharArray().length >= maxWord.length())
                        maxWord = ma;
                }

            }
            return maxWord;
        }
        return null;
    }

    public static String minWord(String input) {

        String[] mas = input.split(" ");
        String minWord = isWord(input);

        if (minWord != null && (countWords(input) != 0)) {

            for (String ma : mas) {
                int count = 0;
                for (char c : ma.toCharArray()) {
                    if (Character.isLetter(c))
                        count++;
                    if (count == ma.toCharArray().length &&
                            (ma.toCharArray().length <= minWord.length()))
                        minWord = ma;
                }
            }
            return minWord;
        }
        return null;
    }

    private static String isWord(String input) {

        String[] mas = input.split(" ");
        String word = null;

        for (String s : mas) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c))
                    count++;
            }
            if (count == s.length()) {
                word = s;
                break;
            }

        }
        return word;
    }
}
