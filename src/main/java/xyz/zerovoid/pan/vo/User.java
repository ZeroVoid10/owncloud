package xyz.zerovoid.pan.vo;

import java.util.Date;

/**
 * user表的vo类
 * @since 0.1.0
 */
public class User {

	private int UID;
	private String name;
	private String password;
	private String mail;
	private String group;
	private Date logOutTime;

	public int getUID() {
		return UID;
	}

	public User setUID(int UID) {
		this.UID = UID;
        return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
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

    private User() {
        super();
    }

    public static User getNewUser() {
        return new User();
    }
	
}
