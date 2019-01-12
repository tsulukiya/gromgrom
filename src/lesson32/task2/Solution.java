package lesson32.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    public static void readNumbers() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int count = 0;
        int countSum = 0;
        String digit;
        System.out.println("Please enter numbers:");

        for (int i = 1; i < 21; i++) {
            digit = br.readLine();
            countSum = Integer.parseInt(digit);
            if (i % 2 == 0 && digit.equals(" ")) {
               // countSum = countSum + Integer.parseInt(digit);

            } else if (i % 2 == 0 && !digit.equals(" ")) {
                countSum = countSum + Integer.parseInt(digit);
                count++;
                System.out.println(countSum);

                if (count < 3) {
                    System.out.println("You numbers are wrong. You have " + (3 - count) + " attempts to try again");
                } else {
                    throw new IOException("Your numbers are wrong. Number of attempts exceeded");
                }
            }


        }
    }
}
