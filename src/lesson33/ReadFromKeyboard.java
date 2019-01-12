package lesson33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboard {

    public static void main(String[] args) throws IOException {

    }

    private static void readKeyboardWithIOStream() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");

        System.out.println("Hello, " + br.readLine() + "!");
    }

}
