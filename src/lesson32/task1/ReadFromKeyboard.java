package lesson32.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {

    public static void main(String[] args) throws IOException {
        readKeyboardWithIOStream();
    }

    private static void readKeyboardWithScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        System.out.println("Hello, " + scanner.nextLine());
        scanner.close();
    }

    private static void readKeyboardWithIOStream() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int count = 0;
        System.out.println("Please enter your name");
        String name = br.readLine();
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c))
                count++;
        }
        if (count == name.length()) {
            System.out.println("Hello, " + name + "!");
        }
        else System.err.println("Name is not correct...");
    }
}
