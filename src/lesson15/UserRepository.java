package lesson15;

import java.util.Arrays;

public class UserRepository {

    private User[] users = new User[10];

    public User save(User user) {
        int index = 0;
        User userSearch = null;
        for (User user1 : users) {
            if (user1 != null && (user1.equals(user))) {
                index++;
                break;
            }
        }

        if (index == 0) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    userSearch = user;
                    break;
                }
            }

        }

        return userSearch;

    }

    public User update(User user) {
        User userSearch = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].equals(user)) {
                    users[i] = user;
                    userSearch = user;
                }

        }
        return userSearch;

    }


/*
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


    public User[] getUsers() {
        return users;
    }
}

