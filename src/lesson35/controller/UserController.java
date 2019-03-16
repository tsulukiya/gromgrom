package lesson35.controller;

import lesson35.model.User;
import lesson35.services.UserService;

import javax.security.auth.login.LoginException;

public class UserController {
    private UserService userService = new UserService();


    public User registerUser(User user, String pathToDb) {
        return userService.registerUser(user, pathToDb);
    }

    public void login(String userName, String password, String pathUserDb) throws LoginException {
        userService.login(userName, password, pathUserDb);
    }

    public void logout() {
        userService.logout();
    }

}
