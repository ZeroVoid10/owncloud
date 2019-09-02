package xyz.zerovoid.pan.vo;

import java.util.Date;
import java.util.Map;

/**
 * user表的vo类
 * @since 0.1.0
 */
public class User {

	private int UID;
	private String mail;
	private String password;
	private String username;
	private String group;
	private Date logOutTime;

	public int getUID() {
		return UID;
	}

	public User setUID(int UID) {
		this.UID = UID;
        return this;
	}

	public String getUsername() {
		return username;
	}

	public User setName(String name) {
		this.username = name;
        return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
        return this;
	}

	public String getMail() {
		return mail;
	}

	public User setMail(String mail) {
		this.mail = mail;
        return this;
	}

	public String getGroup() {
		return group;
	}

	public User setGroup(String group) {
		this.group = group;
        return this;
	}

	public Date getLogOutTime() {
		return logOutTime;
	}

	public User setLog_out(Date time) {
		this.logOutTime = time;
        return this;
	}

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public User(Map<String, String[]> map) {
        this.mail = map.get("mail")[0];
        this.password = map.get("password")[0];
        if (map.containsKey("username")) {
            this.username = map.get("username")[0];
        }
        if (map.containsKey("group")) {
            this.group = map.get("group")[0];
        }
    }

    private User() {
        super();
    }

    public static User getNewUser() {
        return new User();
    }

}
