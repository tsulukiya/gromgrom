package lesson35.services;

import lesson35.repository.UserRepository;
import lesson35.model.User;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) {
        return userRepository.registerUser(user);
    }
}
