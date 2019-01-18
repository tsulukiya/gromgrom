package lesson34.task1;

import java.io.*;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        validate(fileFrom, fileTo);

        try (FileReader fileReader = new FileReader(fileFrom);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(fileTo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String text;

            while ((text = bufferedReader.readLine()) != null) {

                bufferedWriter.write(text);
                bufferedWriter.append("\n");

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + fileFrom.getName());
        } catch (IOException e) {
            System.out.println(e.getMessage() + fileFrom.getName());
        }

    }


    private static void validate(File fileFrom, File fileTo) throws Exception {

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
