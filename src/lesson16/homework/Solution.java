package lesson16.homework;

public class Solution {
    public static void main(String[] args) {

        //String test = "First program in JAVA";
        String test = "aaa2 aaa2 aaa2 zzz4 aaa aaa ccc bbb";
//        String test1 = "";
//        String test2 = "1";
//        String test3 = "aaaa aa1";
//        String test4 = "aaaa% @@@@ @@@@";

        System.out.println(countWords(test));
        //System.out.println(maxWord(test));
        //System.out.println(minWord(test));
        System.out.println(mostCountedWord(test));
//        System.out.println(mostCountedWord(test1));
//        System.out.println(mostCountedWord(test2));
//        System.out.println(mostCountedWord(test3));
//        System.out.println(mostCountedWord(test4));


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


    public static String mostCountedWord(String input) {
        String[] mas = input.split(" ");
        String repeatWord = isWord(input);
        int countWord = countWords(input);
        String[] mas1 = new String[countWord];
        int[] count = new int[mas1.length];
        int m = 0;


        for (String ma : mas) {
            int count1 = 0;
            if (ma != null)
                for (char c : ma.toCharArray()) {
                    if (Character.isLetter(c))
                        count1++;
                }
            if (count1 == ma.toCharArray().length) {
                mas1[m] = ma;
                m++;
            }
        }


        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas1.length; j++) {
                if (mas1[i] != null && mas1[i].equals(mas1[j])) {
                    count[i]++;
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count.length; j++) {
                if (count[i] < count[j]) {
                    repeatWord = mas1[j];
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
