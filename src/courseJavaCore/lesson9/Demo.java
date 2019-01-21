package courseJavaCore.lesson9;

import courseJavaCore.lesson9.userRepository.User;
import courseJavaCore.lesson9.userRepository.UserRepository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User(1001, "Sergei1", "qwqwqw11ssssddd");
        User user2 = new User(10021, "Sergei2", "qwqwqw112ssssddd");
        User user3 = new User(10031, "Sergei3", "qwqwqw113ssssddd");
        User user4 = new User(10041, "Sergei4", "qwqwqw114ssssddd");
        User user5 = new User(10051, "Sergei5", "qwqwqw115ssssddd");
        User user6 = new User(10061, "Sergei6", "qwqwqw116ssssddd");
        User user7 = new User(10071, "Sergei7", "qwqwqw117ssssddd");
        User user8 = new User(10081, "Sergei8", "qwqwqw118ssssddd");
        User user9 = new User(10091, "Sergei9", "qwqwqw119ssssddd");
        User user10 = new User(100001, "Sergei10", "qwqwqw1100ssssddd");
        User user11 = new User(100001, "Sergei10", "qwqwqw1100ssssddd");

        User[] users = new User[]{user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, null};
        System.out.println(Arrays.toString(users));

        // method getUserIds
        // возврат массива Id всех юзеров+
        // если юзер null+
        UserRepository userRepository = new UserRepository(users);
        System.out.println(Arrays.toString(userRepository.getUserIds()));

        //getUserNameById test
        //возврат имени юзера по id +
        //если id нет в массиве +
        System.out.println("+++++++++++++++++++++++++++++++++++");
        UserRepository userRepository1 = new UserRepository(users);
        System.out.println(userRepository1.getUserNameById(1001));
        System.out.println(userRepository1.getUserNameById(2020));

        //getUserById test
        //возврат юзера по его id+
        //если заданого id нет в массиве юзеров+
        System.out.println("++++++++++++++++++++++++++++++++++++");
        UserRepository userRepository2 = new UserRepository(users);
        System.out.println(userRepository2.getUserById(100001));
        System.out.println(userRepository2.getUserById(100002));

    }
}
