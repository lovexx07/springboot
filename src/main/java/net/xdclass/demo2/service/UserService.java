package net.xdclass.demo2.service;

import net.xdclass.demo2.domain.User;

import java.util.List;

public interface UserService {
    int add(User user);
    int addaccount();
    List<User> getAll();
    User findById(Long id);
}
