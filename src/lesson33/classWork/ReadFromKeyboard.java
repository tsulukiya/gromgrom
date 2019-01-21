package lesson33.classWork;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboard {

    public static void main(String[] args) throws IOException {

        readKeyboardWithIOStream1();
        readKeyboardWithIOStream2();

    }

    private static void readKeyboardWithIOStream1() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");

        try {
            System.out.println("Hello, " + br.readLine() + "!");
        } catch (IOException e) {
            System.out.println("Reading from keyboard failed");
        } finally {
            try {
                reader.close();
                br.close();
            } catch (IOException e) {
                System.err.println("Closing streams failed");
            }
        }
    }


    private static void readKeyboardWithIOStream2() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");

        try {
            System.out.println("Hello, " + br.readLine() + "!");
        } catch (IOException e) {
            System.out.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

}
