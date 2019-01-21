package courseJavaCore.lesson33.homeWork2;


import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution1 {

    public static void readFileByConsolePath() throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        System.out.println("Please, enter file path to read: ");

        try {
            String path = bufferedReader.readLine();

            File file = new File(path);
            if (!file.exists()) {
                throw new Exception("File with path " + path + " not found");
            }
            readFile(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(inputStreamReader);
        }
    }


    private static void readFile(String patch) {
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
            System.err.println("Can't read file by path" + patch);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}
