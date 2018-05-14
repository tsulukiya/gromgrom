package lesson15;

import java.util.Arrays;

public class UserRepository {
    private User user1 = new User(10012, "Ann2", "qwe12");
    private User user2 = new User(10013, "Ann3", "qwe13");
    private User user3 = new User(10041, "Ann4", "qwe14");
    private User user4 = new User(10015, "Ann5", "qwe15");
    private User user5 = new User(10061, "Ann6", "qwe16");
    private User user6 = new User(10017, "Ann7", "qwe17");
    private User user7 = new User(10018, "Ann8", "qwe18");
    private User user8 = new User(10019, "Ann9", "qwe19");
    private User user9 = new User(10001, "Ann10", "qwe20");
    //private User user10 = null;

    private User[] users = {user1, user2, user3, user4, user5, user6, user7, user8, user9, null};

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

    public User[] getUsers() {
        return users;
    }
}

