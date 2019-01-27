package lesson35.repository;

import lesson35.model.User;


public class UserRepository {
    private ShareRepository shareRepository = new ShareRepository();

    public User registerUser(User user, String pathToDb) {
        String contentToUserDb = user.getId() + "," + user.getUserName() + "," + user.getCountry() +
                "," + user.getPassword() + "," + user.getUserType();
        shareRepository.writeObjectToDb(contentToUserDb, pathToDb);
        return user;
    }

}
