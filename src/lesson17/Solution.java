package lesson17;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "Departure 12 06 2018 Arrival 25 07 2019";

        System.out.println(Arrays.toString(findNumbers(test)));

    }

//    public static int[] findNumbers(String text) {
//
//        String[] mas = text.split(" ");
//        int[] mas1 = new int[mas.length];
//        int count = 0;
//
//
//        for (String s : mas) {
//                try {
//                    mas1 [count] = Integer.parseInt(s);
//                    count++;
//
//                } catch (Exception e) {
//                    System.out.println("Not a number");
//                }
//
//        }
//        return mas1;
//    }


    public static int[] findNumbers(String text) {

        String[] mas = text.split(" ");
        int[] mas1 = new int[mas.length];
        int count1 = 0;

        for (String s : mas) {
            int count = 0;
            for (char c : s.toCharArray()) {
               if (Character.isLetter(c))
                count++;

            }
            if (count == 0) {
                mas1[count1] = Integer.parseInt(s);
                count1++;
            }
        }


        return mas1;
    }


}
