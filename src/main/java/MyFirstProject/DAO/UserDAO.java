package MyFirstProject.DAO;

import MyFirstProject.model.User;

import java.util.List;

public interface UserDAO {
    List<User> listUsers();
    void addUser(User user);
    User getUserById(int id);
    void removeUser(int id);
}
