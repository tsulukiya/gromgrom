package lesson16.homework;

public class Solution {
    public static void main(String[] args) {

        String s1 = "Hello World";
       // System.out.println(countWords(s1));
        System.out.println(s1.length());
        s1.split(" ");

    }

    int countWords(String input) {
        int count = 0;


        char[] chars = input.toCharArray();

        for (char ch : chars) {
            if (ch == ' ')
                count++;
        }
        return count;
    }

}
