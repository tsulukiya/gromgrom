package lesson33.classWork;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) {

        readFile("/Users/macbook/Downloads/test.txt");
        writeFile("/Users/macbook/Downloads/test2.txt");

    }

    public static void readFile(String patch) {
        FileReader reader;

        try {
            reader = new FileReader(patch);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }
        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + patch + " failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }


    private static void writeFile(String patch) {

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter(patch, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n");

            bufferedWriter.append("TTTTTTTTT");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }

    }
}
