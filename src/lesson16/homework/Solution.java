package lesson16.homework;

public class Solution {
    public static void main(String[] args) {

        String s1 = "Hello World";
        System.out.println(countWords(s1));
        System.out.println(s1.length());

    }

    public static int countWords(String input) {
        int count = 0;

        if (input.length() != 0) {
            count++;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ')
                    count++;
            }
        }
        return count;
    }

}
