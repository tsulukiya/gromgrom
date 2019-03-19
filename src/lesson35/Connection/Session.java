package lesson35.Connection;

import lesson35.model.User;

public class Session {
    public static User user;

    public Session(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
