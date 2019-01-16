package lesson33.homeWork2;

import lesson33.classWork.ReadWriteFile;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

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

            ReadWriteFile.readFile(path);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(inputStreamReader);
        }
    }
}
