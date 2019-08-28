package AllUserTable;

public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		boolean status = new CreateTable(MysqlConnection.getConnection()).create_table();
		if(status) {
			UserManagement um = new UserManagement(MysqlConnection.getConnection());
			//um.add_user("James Fu", "james990401", "mi1430954452@126.com", "god");
			//um.add_user("Annie Li", "annie990910", "idontknow@126.com", "god");
			um.PrintUserInfos(um.getUserInfos(4));
			System.out.println();
		}
	}

}
