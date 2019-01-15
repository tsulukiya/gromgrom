package lesson33.homeWork;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {


    public static void writeToFileFromConsole(String path) throws Exception {
        File file = new File(path);

        if (!file.exists()) {
            throw new Exception("File with path " + path + " not found");
        }

        System.out.println("Enter file content to write in the file:");

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {

            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String text;

            while (!(text = bufferedReader.readLine()).equals("wr")) {
                bufferedWriter.write(text+"\n");
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(inputStreamReader);
        }

    }
}
