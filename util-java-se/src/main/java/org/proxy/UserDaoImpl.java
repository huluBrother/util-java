package org.proxy;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao{
    @Override
    public void add(User user) {
        System.out.println("执行 add 方法 增加对象" + user);
    }

    @Override
    public void update(User user) {
        System.out.println("执行 update 方法 修改对象" + user);
    }

    @Override
    public void remove(User user) {
        System.out.println("执行 remove 方法 移除对象" + user);
    }

    @Override
    public User find() {
        User user = new User("hello",20);
        System.out.println("执行 find 方法 查找对象" + user);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        list.add(new User("hello",20));
        list.add(new User("world",21));

        System.out.println("执行 find 方法 查找对象" + list);
        return list;
    }
}
