package lesson15;

import java.util.Arrays;

public class UserRepository {

    private User[] users = new User[]{new User(1001, "Ann1", "qwe11"), new User(10012, "Ann2", "qwe12"),
            new User(10013, "Ann3", "qwe13"), new User(10041, "Ann4", "qwe14"),
            new User(10015, "Ann5", "qwe15"), new User(10061, "Ann6", "qwe16"),
            new User(10017, "Ann7", "qwe17"), new User(10018, "Ann8", "qwe18"),
            new User(10019, "Ann9", "qwe19"), new User(10001, "Ann10", "qwe20"), null};


    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        int index = 0;
        User userSearch = null;
        for (User user1 : users) {
            if (user.equals(user1)) {
                index++;
                break;
            }
        }

        if (index == 0) {
            for (User user1 : users) {
                if (user1 == null) {
                    user1 = user;
                    userSearch = user1;
                }
            }

        }

        return userSearch;

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

