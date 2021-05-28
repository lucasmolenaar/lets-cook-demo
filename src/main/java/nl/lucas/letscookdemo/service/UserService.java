package nl.lucas.letscookdemo.service;

import nl.lucas.letscookdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUser(long id);
    User addUser(User user);
    void removeUser(long id);
    void updateUser(long id, User user);
}
