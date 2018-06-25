package lesson16.homework;

public class Solution {
    public static void main(String[] args) {

        //String test = "First program in JAVA";
        String test = "aaa";

        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));
        System.out.println(mostCountedWords(test));


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

    public static String minWord(String input) {

        String[] mas = input.split(" ");
        String minWord = isWord(input);

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


    public static String mostCountedWords(String input) {
        String[] mas = input.split(" ");
        String repeatWord = isWord(input);
        int[] count = new int[mas.length];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i].equals(mas[j])) {
                    count[i]++;
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count.length; j++) {
                if (count[i]<count[j]) {
                    repeatWord = mas[j];
                }
            }
        }



        return repeatWord;

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
            if (count == s.length() && countWords(input) > 0) {
                word = s;
                break;
            }

        }
        return word;
    }


}
