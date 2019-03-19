package lesson35.Demo;

import lesson35.Connection.Session;
import lesson35.controller.UserController;
import lesson35.enums.UserType;
import lesson35.model.User;

import javax.security.auth.login.LoginException;

public class DemoUser {

    public static void main(String[] args) throws LoginException {
//        User user = new User("Ivan", "qwerty", "Ukraine", UserType.ADMIN);
//        User user1 = new User("Ivan", "qwerty", "Ukraine", UserType.ADMIN);
 //       User user2 = new User("Ivan", "qwe", "Ukraine", UserType.USER);
        UserController userController = new UserController();
 //       userController.registerUser(user2, "/Users/macbook/Documents/DB final project/UserDb.txt");
//        userController.registerUser(user1, "/Users/macbook/Documents/DB final project/UserDb.txt");
//        userController.registerUser(user2, "/Users/macbook/Documents/DB final project/UserDb.txt");

        userController.login("Ivan", "qwe",
                "/Users/macbook/Documents/DB final project/UserDb.txt");


        //userController.login("Ivan", "qwe",
                //"/Users/macbook/Documents/DB final project/UserDb.txt");



    }
}
