package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUserById(long id);

    void updateUserById(long id, User user);

    User getUserById(long id);

    List<User> getListOfUsers();
}
