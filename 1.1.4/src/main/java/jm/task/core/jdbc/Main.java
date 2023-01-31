package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        try {
            Util.getConnect();
            UserDao userDao = new UserDaoHibernateImpl();
            userDao.createUsersTable();

            userDao.saveUser("Harry", "Potter", (byte) 17);
            userDao.saveUser("Hermione", "Granger", (byte) 16);
            userDao.saveUser("Ron", "Weasley", (byte) 18);
            userDao.saveUser("Draco", "Malfoy", (byte) 21);

            userDao.removeUserById(1);
            System.out.println(userDao.getAllUsers());
            userDao.cleanUsersTable();
            userDao.dropUsersTable();
        } finally {
            Util.getSessionFactory().close();
        }
    }
}
