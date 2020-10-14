package cn.xfakir.jdbc.service;

import cn.xfakir.jdbc.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> getUsers();
}
