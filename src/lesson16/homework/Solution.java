package lesson16.homework;

public class Solution {
    public static void main(String[] args) {

        int [][] array= new int[4][];
        System.out.println(array.length);

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
