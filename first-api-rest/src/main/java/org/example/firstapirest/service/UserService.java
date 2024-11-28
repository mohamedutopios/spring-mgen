package org.example.firstapirest.service;


import org.example.firstapirest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("1", "John Doe", "john@doe.com"));
        users.add(new User("2", "Jane Doe", "jane@doe.com"));
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserById(String id) {
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public User createUser(User user){
        users.add(user);
        return user;
    }

    public Optional<User> updateUser(String id, User user){
      return getUserById(id)
              .map(user1 -> {
          user1.setName(user.getName());
          user1.setEmail(user.getEmail());
          return user1;
      });
    }

    public boolean deleteUser(String id) {
        return users.removeIf(user -> user.getId().equals(id));
    }


}
