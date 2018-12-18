package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface IUserDao {
    public int insert(User user);
    public User getOne(String username);
    public List<User> getLists();
}
