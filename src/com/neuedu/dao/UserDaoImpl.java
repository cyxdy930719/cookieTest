package com.neuedu.dao;

import com.neuedu.pojo.User;
import com.neuedu.untiltest.JdbcUntil;
import com.neuedu.untiltest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    @Override
    public int insert(User user) {
        return JdbcUntil.executeUpdate("insert into user(username,password,tele) values(?,?,?)",user.getUsername(),user.getPassword(),user.getTele());
    }

    @Override
    public User getOne(String username) {
        return JdbcUntil.QueryOne("select username,password,tele from user where username=?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet rs) {
                User u = new User();
                try {
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setTele(rs.getString("tele"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }

    @Override
    public List<User> getLists() {
        return JdbcUntil.executeQuery("select username from user", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet rs) {
                User u = new User();
                try {
                    u.setUsername(rs.getString("username"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, null);
    }


}
