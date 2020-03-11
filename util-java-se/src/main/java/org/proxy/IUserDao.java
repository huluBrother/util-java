package org.proxy;

import java.util.List;

public interface IUserDao {

    void add(User user);

    void update(User user);

    void remove(User user);

    User find();

    List<User> findAll();
}
