package lesson35.services;

import lesson35.repository.UserRepository;
import lesson35.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private long idUser = 101;


    public User registerUser(User user) throws IOException {
        user.setId(idUser++);
        validateWriteToDb(user);
        return userRepository.registerUser(user);
    }


    private static void validateWriteToDb(User user) throws IOException {

        if (user.getUserType() == null || user.getPassword() == null || user.getCountry() == null ||
                user.getUserName() == null) {
            throw new NullPointerException("User with ID: " +user.getId() +
                    " have null field. Method - validateWriteToDb");
        }
    }
}

