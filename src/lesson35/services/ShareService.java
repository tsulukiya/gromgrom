package lesson35.services;

import java.io.*;

public class ShareService {

    public void validatePathFileTo(String path) throws IOException {
        File fileTo = new File(path);

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + "does not exist");
        }
        if (!fileTo.canWrite()) {
            throw new IOException("File " + fileTo + " does not have permission to be written");
        }
    }
}


