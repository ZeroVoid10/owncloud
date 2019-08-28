package ProjectUser;

public class PUser {
	
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	int UID;
	String access;
	public PUser(int UID, String access) {
		this.UID = UID;
		this.access = access;
	}
}
