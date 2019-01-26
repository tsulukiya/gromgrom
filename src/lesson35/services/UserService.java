package lesson35.services;

import lesson35.repository.UserRepository;
import lesson35.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private long idUser = 101;


    public User registerUser(User user, String userDbPath) throws IOException {
        user.setId(idUser++);
        validateWriteToDb(user, userDbPath);
        return userRepository.registerUser(user, userDbPath);
    }


    private static void validateWriteToDb(User user, String userDbPath) throws IOException {
        File fileTo = new File(userDbPath);

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + "does not exist. Method - validateWriteToDb");
        }

        if (!fileTo.canWrite()) {
            throw new IOException("File " + fileTo + " does not have permission to be written. " +
                    "Method - validateWriteToDb");
        }

        if (user.getUserType() == null || user.getPassword() == null || user.getCountry() == null ||
                user.getUserName() == null) {
            throw new NullPointerException("User with ID: " +user.getId() +
                    " have null field. Method - validateWriteToDb");
        }
    }
}

