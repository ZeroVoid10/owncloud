package xyz.zerovoid.pan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xyz.zerovoid.pan.vo.User;

public class UserDao {
    
    private DatabaseConnection dbc = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public UserDao() throws SQLException {
        dbc = new DatabaseConnection();
        conn = dbc.getConnection();
    }

    public boolean doInsert(User user) throws SQLException {
        boolean flag = false;
        String sql = "insert into user (mail, password, username, groupname) values(?,?,?,?)";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setString(1, user.getMail());
        this.pstmt.setString(2, user.getPassword());
        this.pstmt.setString(3, user.getUsername());
        this.pstmt.setString(4, user.getGroup());
        if (this.pstmt.executeUpdate() > 0) {
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    public User findUser(int uid) throws SQLException {
        String sql = "select * from user where uid=?";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setInt(1, uid);
        return res2User();
    }

    public User findUser(String mail) throws SQLException {
        String sql = "select * from user where mail=?";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setString(1, mail);
        return res2User();
    }

    public boolean doModify(User user) throws SQLException {
        boolean flag = false;
        return flag;
    }

    private User res2User() throws SQLException {
        User user = null;
        ResultSet res = this.pstmt.executeQuery();
        if (res.next()) {
            user = User.getNewUser()
                    .setUID(res.getInt("uid"))
                    .setMail(res.getString("mail"))
                    .setName(res.getString("username"))
                    .setPassword(res.getString("password"))
                    .setGroup(res.getString("groupname"));
        }
        this.pstmt.close();
        return user;
    }
}


