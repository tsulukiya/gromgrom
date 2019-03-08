package lesson35.repository;

import lesson35.model.User;

public class UserRepository extends ShareRepository {

    public User registerUser(User user, String pathToDb) {
        writeObjectToDb(user.toString(), pathToDb);
        return user;
    }

    @Override
    Object initObject(String[] mas) {
        return null;
    }
}
