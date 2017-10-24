package MyFirstProject.Service;

import MyFirstProject.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserByID(int id);
    void deleteUserById(int id);
    void addUser(User user);
}
