package courseJavaCore.lesson17.dz1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "1 Departure 12 06 2018 Arrival 25 07 2019";

        System.out.println(Arrays.toString(findNumbers(test)));

    }

    public static int[] findNumbers(String text) {

        String[] mas = text.split(" ");
        int count = 0;

        for (String ma : mas) {

            try {
                Integer.parseInt(ma);
                count++;
            } catch (Exception e) {

            }
        }

        int[] mas1 = new int[count];

        count = 0;

        for (String s : mas) {

            try {

                mas1[count] = Integer.parseInt(s);
                count++;

            } catch (Exception e) {
                System.out.println("Not a number");
            }

        }
        return mas1;
    }

}
