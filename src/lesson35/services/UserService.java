package lesson35.services;

import lesson35.repository.UserRepository;
import lesson35.model.User;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return userRepository.registerUser(user);
    }
}
