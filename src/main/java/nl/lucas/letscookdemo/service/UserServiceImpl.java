package nl.lucas.letscookdemo.service;

import nl.lucas.letscookdemo.exception.RecordNotFoundException;
import nl.lucas.letscookdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(long id) {
        User user = null;

        for (int i = 0; i < users.size(); i++) {
            if (id == users.get(i).getId()) {
                user = users.get(i);
            }
        }

        if (user == null) {
            throw new RecordNotFoundException("User not found");
        } else {
            return user; //Checken of dit wel kan, anders returnen na if statement
        }
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public void removeUser(long id) {
        User user = null;

        for (int i = 0; i < users.size(); i++) {
            if (id == users.get(i).getId()) {
                user = users.get(i);
            }
        }

        if (user == null) {
            throw new RecordNotFoundException("User not found");
        } else {
            users.remove(user);
        }
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User user = null;

        for (int i = 0; i < users.size(); i++) {
            if (id == users.get(i).getId()) {
                user = users.get(i);
            }
        }

        if (user == null) {
            throw new RecordNotFoundException("User not found");
        } else {
            user.setId(updatedUser.getId());
            user.setUsername(updatedUser.getUsername());
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setAge(updatedUser.getAge());
        }
    }
}
