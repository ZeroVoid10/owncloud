package ProjectUser;

import AllUserTable.MysqlConnection;

public class test {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		boolean status = new CreateTable(MysqlConnection.getConnection(), "xiaoxueqi").create_table();
		if(status) {
			PUserManagement pm = new PUserManagement(MysqlConnection.getConnection(), "xiaoxueqi");
			pm.add_PUser(3,"project_leader");
		}
	}
}
