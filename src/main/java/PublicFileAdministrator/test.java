package PublicFileAdministrator;

import AllUserTable.MysqlConnection;

public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		boolean status = new CreateTable(MysqlConnection.getConnection()).create_table();
		if(status) {
			administratorManagement am = new administratorManagement(MysqlConnection.getConnection());
			am.add_administrator(1);
			am.add_administrator(2);
			//am.delete_administrator(1);
			//am.delete_administrator(2);
			am.add_administrator(4);
		}
	}

}
