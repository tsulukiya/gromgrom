package lesson35.repository;

import lesson35.model.User;


public class UserRepository {
    ShareRepository shareRepository = new ShareRepository();

    public User registerUser(User user, String userDbPath) {
        String contentToUserDb = user.getId() + "," + user.getUserName() + "," + user.getCountry() +
                "," + user.getPassword() + "," + user.getUserType();
        shareRepository.writeObjectToDb(contentToUserDb, userDbPath);
        return user;
    }

}
