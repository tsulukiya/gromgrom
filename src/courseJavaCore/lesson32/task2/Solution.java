package courseJavaCore.lesson32.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void readNumbers() throws IOException {
        byte totalAttempts = 3;

        while (totalAttempts != 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String input = br.readLine();
            String [] items = input.split(" ");

            if (!validate(items)) {
                if (totalAttempts == 1) {
                    System.out.println("Your number are wrong. Number of attempts exceeded");
                    return;
                }

                System.out.println("Your numbers are wrong. You have " + --totalAttempts + " attempts to try again");
                continue;
            }

            int res = 0;
            for (String item : items) {
                res += Integer.parseInt(item);
            }

            System.out.println(res);
            return;
        }

    }

    private static boolean validate(String [] input) {
        if (input.length!=10)
            return false;

        for (String numberToCheck : input) {
            for (char ch : numberToCheck.toCharArray()) {
                if (!Character.isDigit(ch))
                    return false;
            }

            if (Integer.parseInt(numberToCheck)>100)
                return false;
        }
        return true;
    }
}
