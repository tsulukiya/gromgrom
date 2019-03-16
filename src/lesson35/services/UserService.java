package lesson35.services;

import lesson35.repository.UserRepository;
import lesson35.model.User;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user, String pathToDb) {
        user.setId(setUserId());
        validateUserToNullFields(user);
        validateUserDuplicatesInUserDb(user, pathToDb);
        return userRepository.registerUser(user, pathToDb);
    }

    public void login(String userName, String password, String pathUserDb) throws LoginException {
        @SuppressWarnings("unchecked")
        List<User> userList = userRepository.convertContentFromPathToList(pathUserDb);
        int count = 0;
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
               userRepository.login(userName, password, pathUserDb);
               count++;
               break;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("User with name:" + userName + " is not in UserDB" + pathUserDb +
                    "Class.UserService. Method - login.");
        }
    }


    public void logout() {
        userRepository.logout();
    }


    private void validateUserToNullFields(User user) {

        if (user.getUserType() == null || user.getPassword() == null || user.getCountry() == null ||
                (user.getUserName() == null || user.getId() == 0)) {
            throw new NullPointerException("User with ID: " + user.getId() + " have null field. Method - " +
                    "validateUserToNullFields. Class - UserService");
        }
    }

    private long setUserId() {
        Random random = new Random();
        return random.nextInt(10000) + 101;

    }


    private void validateUserDuplicatesInUserDb(User user, String path) {
        @SuppressWarnings("unchecked")
        List<User> userList = userRepository.convertContentFromPathToList(path);

        for (User user1 : userList) {
            if (user1.getId() == user.getId()) {
                throw new ConcurrentModificationException("User with ID:" + user.getId() + " is in DB" + path +
                        "Class.UserService. Method - validateUserDuplicatesInUserDb.");
            }
        }

    }
}

