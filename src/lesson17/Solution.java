package lesson17;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "Departure 12 06 2018 Arrival 25 07 2019";

        System.out.println(Arrays.toString(findNumbers(test)));

    }

    public static int[] findNumbers(String text) {

        String[] mas = text.split(" ");
        int[] mas1 = new int[mas.length];
        int count = 0;


        for (String s : mas) {
                try {
                    mas1 [count] = Integer.parseInt(s);
                    count++;

                } catch (Exception e) {
                    System.out.println("Not a number");
                }

        }
        return mas1;


    }
}
