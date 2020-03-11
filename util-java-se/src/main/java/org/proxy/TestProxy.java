package org.proxy;

public class TestProxy {

    public static void main(String[] args) {
        IUserDao dao = (IUserDao) new DaoProxy().bind(new UserDaoImpl());
        dao.add(new User("hello",20));
        dao.find();
    }
}
