package lesson16.homework;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        String test = "Hello World is first program";

        System.out.println(countWords(test));


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
}
