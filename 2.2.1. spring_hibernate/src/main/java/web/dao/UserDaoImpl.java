package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUserById(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUserById(long id, User user) {
        User oldUser = getUserById(id);
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        oldUser.setAge(user.getAge());
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getListOfUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }
}