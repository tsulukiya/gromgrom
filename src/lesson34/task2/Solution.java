package lesson34.task2;

import java.io.*;

public class Solution {


    public static void transferFileContetnt(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);

        readFromFile(fileFromPath);

        writeToFile(fileToPath, readFromFile(fileFromPath));

        deleteContentFileFrom(fileFromPath);


    }

    private static void deleteContentFileFrom(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append("");
        }catch (IOException e) {
            System.err.println(e.getMessage() + path);
        }

    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        }catch (IOException e) {
            System.err.println(e.getMessage() + path);
        }

    }


    private static  StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length()-1, res.length(), "");
        } catch (IOException e) {
            System.err.println(e.getMessage() + path);
        }
        return res;

    }


    private static void validate(String fileFromPath, String fileToPath) throws Exception {
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
