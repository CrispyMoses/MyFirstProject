package MyFirstProject.DAO;

import MyFirstProject.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDAO {

    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List<User> users = getSession().createQuery("from User").list();
        return users;
    }

    @Override
    public void addUser(User user) {
        getSession().save(user);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User getUserById(int id) {
        User user = getSession().get(User.class, new Integer(id));
        return user;
    }

    @Override
    public void removeUser(int id) {
        getSession().delete(getUserById(id));
    }
}
