package lesson34.task1;

import java.io.*;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws FileNotFoundException {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists() || !fileTo.exists()) {
            throw new FileNotFoundException("File does not exist");
        }

        try (FileReader fileReader = new FileReader(fileFrom);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(fileTo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String text;

            while ((text = bufferedReader.readLine())!=null) {

                bufferedWriter.write(text);
                bufferedWriter.append("\n");

            }

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + fileFrom.getName());
        }catch (IOException e) {
            System.out.println(e.getMessage() + fileFrom.getName());
        }

    }
}
