package lesson16.homework;

public class Solution {
    public static void main(String[] args) {

        String s1 = "Hello World";
        System.out.println(countWords(s1));

    }

    public static int countWords(String input) {
        return input.split(" ").length;
    }
}
