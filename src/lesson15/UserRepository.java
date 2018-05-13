package lesson15;

import java.util.Arrays;

public class UserRepository {

    private User[] users = new User[10];


    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        int index = 0;
        User userSearch = null;
        for (User user1 : users) {
            if (user != null && user1 != null)
                if (user.equals(user1)) {
                    index++;
                    break;
                }
        }

        if (index == 0) {
            for (User user1 : users) {
                if (user1 == null) {
                    user1 = user;
                    //userSearch = user1;
                    break;
                }
            }

        }

        return user;

    }

   /* public User update (User user) {

    }

    public void delete(long id) {

    }

    public User findById(long id){

    }*/

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}

