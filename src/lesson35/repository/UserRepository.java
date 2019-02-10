package lesson35.repository;

import lesson35.model.User;

import java.io.IOException;

public class UserRepository extends ShareRepository {

    public User registerUser(User user, String pathToDb) {
        try {
            validatePathFileTo(pathToDb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeObjectToDb(convertObjectToStringContent(user), pathToDb);
        return user;
    }

}
