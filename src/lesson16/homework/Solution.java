package lesson16.homework;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        String test = "Hello World is first program";

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

        String [] mas = input.split(" ");
        String maxWord = mas[0];
        int count = 0;

        for (String ma : mas) {
            count = 0;
            for (char c : ma.toCharArray()) {
                if (Character.isLetter(c))
                    count++;
                if (count == ma.toCharArray().length)
                    if (ma.toCharArray().length > maxWord.length())
                        maxWord = ma;
            }

        }
        return maxWord;


    }

    public static String minWord(String input) {

        String [] mas = input.split(" ");
        String minWord = mas[0];
        int count = 0;

        for (String ma : mas) {
            count = 0;
            for (char c : ma.toCharArray()) {
                if (Character.isLetter(c))
                    count++;
                if (count == ma.toCharArray().length)
                    if (ma.toCharArray().length < minWord.length())
                        minWord = ma;
            }

        }
        return minWord;


    }
}
