package net.xdclass.demo2.service.impl;

import net.xdclass.demo2.domain.User;
import net.xdclass.demo2.mapper.UserMapper;
import net.xdclass.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id = user.getId();
        return id;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int addaccount() {
        User user = new User();
        user.setAge(21);
        user.setCreateTIme(new Date());
        user.setName("测试事物 加入事物");
        user.setPhone("10230110000");

        userMapper.insert(user);
        int id = user.getId();
        int i = 10 / 0;
        return id;
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
