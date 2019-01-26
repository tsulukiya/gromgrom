package lesson35.repository;

import java.io.*;

public class ShareRepository {



    public void writeObjectToDb(String contentToWriteDb, String pathDb) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathDb, true))) {
            bufferedWriter.append(contentToWriteDb);
            bufferedWriter.append("\n");
        } catch (IOException e) {
            System.err.println(e.getMessage() + pathDb);
        }
    }
}
