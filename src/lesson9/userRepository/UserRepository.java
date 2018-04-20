package lesson9.userRepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public String[] getUserNames() {
        String[] names = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                names[i] = users[i].getName();
        }
        return names;
    }

    public String[] getUserIds() {
        String[] id = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                id[i] = users[i].getSessionId();
        }
        return id;
    }

    public String getUserNameById(long id) {
        String nameUser = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getId() == id) {
                    nameUser = users[i].getName();
                }
        }
        return nameUser;
    }

    public User[] getUsers() {
        return users;
    }
}

