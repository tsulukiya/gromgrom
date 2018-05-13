package lesson15;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
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

        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.save(null));
        System.out.println(Arrays.toString(userRepository.getUsers()));


    }
}
