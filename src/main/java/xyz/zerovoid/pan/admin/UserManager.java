package xyz.zerovoid.pan.admin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
    	HashMap<String, String[]> newMap = new HashMap<String, String[]>(map);
        User user = new User(newMap);
        return userDao.doInsert(user);
    }

    public int login(Map<String, String[]> map, HttpSession session) throws SQLException {
        User user = userDao.findUser(map.get("mail")[0]);
        if (user == null) {
            return 2; // user mail does not register
        } else if (user.getPassword().compareTo(map.get("password")[0]) != 0) {
            return 1; // password incorrect
        }
        session.setAttribute("uid", user.getUID());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("mail", user.getMail());
        return 0;
    }
}
