package courseJavaCore.lesson27.homeWork.two;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public int count() {
        return users.size();
    }


    public ArrayList<String> getUserNames() {
        ArrayList<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.getName());
        }
        return names;
    }


    public ArrayList<Long> getUserIds() {
        ArrayList<Long> id = new ArrayList<>();

        for (User user : users) {
            id.add(user.getId());
        }
        return id;
    }


    public String getUserNameById(long id) {
        String nameUser = null;
        for (User user : users) {
            if (user.getId() == id) {
                nameUser = user.getName();
                break;
            }
        }
        return nameUser;
    }

    public User getUserByName(String name) {
        User user1 = null;
        for (User user : users) {
            if (user.getName().equals(name)) {
                user1 = user;
                break;
            }
        }
        return user1;
    }

    public User getUserById(long id) {
        User user1 = null;
        for (User user : users) {
            if (user.getId() == id) {
                user1 = user;
                break;
            }
        }
        return user1;
    }


    public User findById(long id) {
        User user1 = null;
        for (User user : users) {
            if (user.getId() == id) {
                user1 = user;
                break;
            }
        }
        return user1;
    }


    public User getUserBySessionId(String sessionId) {
        User user1 = null;
        for (User user : users) {
            if (user.getSessionId() == sessionId) {
                user1 = user;
                break;
            }
        }
        return user1;
    }


    public User save(User user) {
        if (!users.contains(user)) {
            users.add(user);
            return user;
        }
        return null;
    }


    public User update(User user) {

        if (users.contains(user)) {

            for (User user1 : users) {
                if (user1.equals(user)) {
                    users.set(users.indexOf(user1), user);
                    return user;
                }
                break;
            }

        }
        return null;
    }


    public void delete(long id) {

        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
            }
        }
    }


    public ArrayList<User> getUsers() {
        return users;
    }
}
