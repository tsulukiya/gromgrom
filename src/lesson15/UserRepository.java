package lesson15;

import java.util.Arrays;

public class UserRepository {

    private User[] users = new User[10];

    public User save(User user) {
        User userSearch = findById(user.getId());

        if (userSearch == null) {
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
        User searchUser = findById(user.getId());
        if (searchUser != null)
            for (int i = 0; i < users.length; i++) {
                if ((users[i] != null &&
                        users[i].equals(searchUser))) {
                    users[i] = user;
                    searchUser = user;
                    break;
                }


            }


        return searchUser;
    }


    public void delete(long id) {
        User searchUser = findById(id);
        if (searchUser != null)
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null && (users[i].equals(searchUser))) {
                    users[i] = null;
                    break;
                }
            }

    }

    public User findById(long id) {
        User user1 = null;
        for (User user : users) {
            if (user != null)
                if (user.getId() == id) {
                    user1 = user;
                    break;
                }
        }
        return user1;
    }

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

