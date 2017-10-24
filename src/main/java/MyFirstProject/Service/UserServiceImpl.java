package MyFirstProject.Service;

import MyFirstProject.DAO.UserDAO;
import MyFirstProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.listUsers();
    }

    @Override
    public User getUserByID(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.removeUser(id);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
