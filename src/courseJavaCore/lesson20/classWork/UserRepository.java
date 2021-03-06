package courseJavaCore.lesson20.classWork;


import courseJavaCore.lesson20.classWork.exception.BadRequestException;
import courseJavaCore.lesson20.classWork.exception.InternalServerException;
import courseJavaCore.lesson20.classWork.exception.UserNotFoundException;

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

    public User getUserByName(String name) {
        User user1 = null;
        for (User user : users) {
            if (user != null) {
                if (user.getName() == name) {
                    user1 = user;
                    break;
                }
            }
        }
        return user1;
    }

    public User getUserById(long id) {
        User user1 = null;
        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) {
                    user1 = user;
                    break;
                }
            }
        }
        return user1;
    }


    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }

        throw new UserNotFoundException("User with id " + id + " not found");
    }


    public User getUserBySessionId(String sessionId) {
        User user1 = null;
        for (User user : users) {
            if (user != null) {
                if (user.getSessionId() == sessionId) {
                    user1 = user;
                    break;
                }
            }
        }
        return user1;
    }


    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id " + user.getId() + " not found. Will by saved");
        }

        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServerException("Not enough space to save user with id " + user.getId());
    }


    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());

        int index = 0;
        for (User us : users) {
            if (us != null && us.getId() == user.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServerException("Unexpected error");
    }


    public void delete(long id) throws Exception {
        findById(id);

        int index = 0;
        for (User us : users) {
            if (us.getId() == id) {
                users[index] = null;
                break;
            }
            index++;
        }
    }


    public User[] getUsers() {
        return users;
    }
}

