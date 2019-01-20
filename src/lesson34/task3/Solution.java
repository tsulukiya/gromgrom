package lesson34.task3;

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {

        validateFile(fileFromPath, fileToPath);

        readFromFileToBuffer(fileFromPath);

        writeToFile(fileToPath, contentToPath(readFromFileToBuffer(fileFromPath), word));


    }


    private static void writeToFile(String path, ArrayList<String> arrayList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            for (String s : arrayList) {
                bufferedWriter.append(s);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage() + path);
        }

    }

    private static ArrayList<String> contentToPath(StringBuffer contentFromFile, String word) {

        ArrayList<String> sentence = new ArrayList<>();

        String[] masString = contentFromFile.toString().split("\\.");

        for (String s : masString) {
            if (s.length() > 10) {
                for (String s1 : s.split(" ")) {
                    if (s1.contains(word)) {
                        sentence.add(s.concat("."));
                    }
                }
            }
        }

        return sentence;

    }

    private static StringBuffer readFromFileToBuffer(String path) {
        StringBuffer contentFileFrom = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                contentFileFrom.append(line);
            }
            contentFileFrom.replace(contentFileFrom.length() - 1, contentFileFrom.length(), "");
        } catch (IOException e) {
            System.err.println(e.getMessage() + path);
        }
        return contentFileFrom;

    }

    private static void validateFile(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + "does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + "does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to be read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permission to be written");
        }
    }
}
