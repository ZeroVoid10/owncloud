package xyz.zerovoid.pan.admin;

import java.sql.SQLException;
import java.util.Map;

import xyz.zerovoid.pan.dao.DAOFactory;
import xyz.zerovoid.pan.dao.UserDao;
import xyz.zerovoid.pan.vo.User;

/**
 * @since 0.1.0
 */
public class UserManager {

    private UserDao userDao;

    public UserManager() throws SQLException {
        this.userDao = DAOFactory.getUserDAO();
    }

    public boolean register(User user) throws SQLException {
        return userDao.doInsert(user);
    }

    public boolean register(String mail, String password) throws SQLException {
        User user = new User(mail, password);
        return userDao.doInsert(user);
    }

    //FIXME: 重复注册问题
    public boolean register(Map<String, String[]> map) throws SQLException {
        User user = new User(map);
        return userDao.doInsert(user);
    }
}
