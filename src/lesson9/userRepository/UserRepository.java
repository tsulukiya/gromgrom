package lesson9.userRepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public int count() {
        int count = 0;
        for (User user : users) {
            if (user != null)
                count++;

        }
        return count;
    }

    public String[] getUserNames() {
        String[] names = new String[count()];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                names[i] = users[i].getName();
        }
        return names;
    }

    public long[] getUserIds() {
        long[] id = new long[count()];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                id[i] = users[i].getId();
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

