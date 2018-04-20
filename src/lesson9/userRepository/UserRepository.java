package lesson9.userRepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public String[] getUserNames() {

        String[] names = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName() != null)
                names[i] = users[i].getName();
            else continue;

        }
        return names;
    }

    public long[] getUserIds() {
        long[] id = new long[users.length];
        for (int i = 0; i < users.length; i++) {
            id[i] = users[i].getId();

        }
        return id;
    }

    public String getUserNameById(long id) {
        String nameUser = null;
        for (User user : users) {
            if (user.getId() == id) {
                nameUser = user.getName();
            }
        }
        return nameUser;
    }

    public User[] getUsers() {
        return users;
    }
}

