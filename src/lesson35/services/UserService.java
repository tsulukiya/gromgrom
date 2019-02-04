package lesson35.services;

import lesson35.repository.UserRepository;
import lesson35.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserService extends ShareService {
    private UserRepository userRepository = new UserRepository();
    private static long countId = 101;

    public User registerUser(User user, String pathToDb) {
        user.setId(countId++);
        validateWriteToDb(user, pathToDb);
        return userRepository.registerUser(user, pathToDb);
    }


    private void validateWriteToDb(User user, String pathToDb) {

        if (user.getUserType() == null || user.getPassword() == null || user.getCountry() == null ||
                user.getUserName() == null || user.getId() == 0) {
            throw new NullPointerException("User with ID: " + user.getId() +
                    " have null field. Method - validateWriteToDb");
        }
        try {
            validatePathFileTo(pathToDb);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void validatePathFileTo(String path) throws IOException {
        super.validatePathFileTo(path);
    }
}

