package lesson17.dz2;

import java.util.Arrays;

import static lesson17.dz1.Solution.isDigit;

public class Solution {
    public static void main(String[] args) {
        String test = "Departure 12 06 2018 Arrival 25 07 2019";

        System.out.println(Arrays.toString(findNumbers(test)));

    }

    public static int[] findNumbers(String text) {

        String[] mas = text.split(" ");
        int count = 0;
        int count1 = 0;

        for (String s : mas) {
            if (isDigit(s))
                count++;

        }

        int[] mas1 = new int[count];


        for (String s : mas) {
            if (isDigit(s)) {
                mas1[count1] = Integer.parseInt(s);
                count1++;
            }
        }


        return mas1;
    }

}
