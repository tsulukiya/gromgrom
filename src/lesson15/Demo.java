package lesson15;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.save(new User(10001, "Ann10", "qwe201")));
        System.out.println(Arrays.toString(userRepository.getUsers()));


    }
}
