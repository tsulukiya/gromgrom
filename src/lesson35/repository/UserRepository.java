package lesson35.repository;

import lesson35.Connection.Session;
import lesson35.enums.UserType;
import lesson35.model.User;

import javax.security.auth.login.AccountException;
import javax.security.auth.login.LoginException;
import java.util.List;

public class UserRepository extends ShareRepository {

    public User registerUser(User user, String pathToDb) {
        writeObjectToDb(user.toString(), pathToDb);
        return user;
    }

    public void login(String userName, String password, String pathUserDb) throws LoginException {
        @SuppressWarnings("unchecked")
        List<User> userList = convertContentFromPathToList(pathUserDb);

        if (Session.user != null) {
            throw new LoginException("This user is already logged in");
        }

        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                Session.user = user;
                System.out.println("Login user with name: " + user.getUserName() + " is OK");
                break;
            }
        }
    }


    public void logout() {
        try {
            checkLoginUser();
        } catch (LoginException e) {
            System.err.println("User is not login...Method logout. Class UserRepository");
        }
        Session.user = null;
    }


    public void checkLoginUser() throws LoginException {

        if (Session.user == null) {
            throw new LoginException("User is not login");
        }

    }

    public void checkUserType() throws AccountException {

            if (Session.user.getUserType().equals(UserType.USER)) {
                throw new AccountException("Not enough rights. This method for admin");
            }
    }


    @Override
    Object initObject(String[] mas) {
        return new User(Long.parseLong(mas[0]), mas[1], mas[2], mas[3], UserType.valueOf(mas[4]));
    }

}
