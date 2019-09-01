package AllUserTable;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		boolean status = new CreateTable(MysqlConnection.getConnection()).create_table();
		if(status) {
			UserManagement um = new UserManagement(MysqlConnection.getConnection());
			//um.add_user("James Fu", "james990401", "mi1430954452@126.com", "god");
			//um.add_user("Annie Li", "annie990910", "idontknow@126.com", "god");
			//um.update_log_out(4);
			//um.PrintUserInfos(um.getUserInfos(4));
			//System.out.println();
			List<Integer> UIDs = new ArrayList<Integer>();
			UIDs = um.search_user("Li");
			for(Integer i : UIDs) {
				um.PrintUserInfos(um.getUserInfos(i));
				System.out.println();
			}
		}
	}

}
