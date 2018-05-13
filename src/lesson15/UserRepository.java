package lesson15;

import java.util.Arrays;

public class UserRepository {
    User user1 = new User(10012, "Ann2", "qwe12");
    User user2 = new User(10013, "Ann3", "qwe13");
    User user3 = new User(10041, "Ann4", "qwe14");
    User user4 = new User(10015, "Ann5", "qwe15");
    User user5 = new User(10061, "Ann6", "qwe16");
    User user6 = new User(10017, "Ann7", "qwe17");
    User user7 = new User(10018, "Ann8", "qwe18");
    User user8 = new User(10019, "Ann9", "qwe19");
    User user9 = new User(10001, "Ann10", "qwe20");
    User user10 = null;

    private User[] users = new User[]{user1, user2, user3,user4,user5,user6,user7,user8,user9,user10};



    public User[] getUsers() {
        return users;
    }

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
            for (User user1 : users) {
                if (user1 == null) {
                    user1 = user;
                    userSearch = user1;
                    break;
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

