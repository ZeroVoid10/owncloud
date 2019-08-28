package AllUserTable;

public class User {

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getLog_out() {
		return log_out;
	}

	public void setLog_out(String log_out) {
		this.log_out = log_out;
	}


	int UID;
	String name;
	String password;
	String mail;
	String group;
	String log_out;
	
	public User(int UID, String name, String password, String mail, String group, String log_out) {
		this.UID = UID;
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.group = group;
		this.log_out = log_out;
	}
	
}
