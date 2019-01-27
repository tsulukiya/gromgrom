package lesson35.services;

import lesson35.repository.UserRepository;
import lesson35.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private ShareService shareService = new ShareService();
    private long idUser = 101;


    public User registerUser(User user, String pathToDb) {
        user.setId(idUser++);
        validateWriteToDb(user, pathToDb);
        return userRepository.registerUser(user, pathToDb);
    }


    private void validateWriteToDb(User user, String pathToDb) {

        if (user.getUserType() == null || user.getPassword() == null || user.getCountry() == null ||
                user.getUserName() == null || user.getId() == 0) {
            throw new NullPointerException("User with ID: " +user.getId() +
                    " have null field. Method - validateWriteToDb");
        }
        try {
            shareService.validatePathFileTo(pathToDb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

