package lesson35.services;

import lesson35.repository.UserRepository;
import lesson35.model.User;

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
        List<User> userList = convertContentFromPathToListUser(path);

        for (User user1 : userList) {
            if (user1.getId() == user.getId()) {
                throw new ConcurrentModificationException("User with ID:" + user.getId() + " is in DB" + path +
                        "Class.UserService. Method - validateUserDuplicatesInUserDb.");
            }

        }


    }

    public List<User> convertContentFromPathToListUser(String path) {
        File file = new File(path);
        List<User> userList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] mas = line.split(",");
                User user = new User(Long.parseLong(mas[0]));
                userList.add(user);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return userList;
    }
}

