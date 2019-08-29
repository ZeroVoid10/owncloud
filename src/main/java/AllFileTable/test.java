package AllFileTable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		boolean status = new CreateTable(MysqlConnection.getConnection()).create_table();
		if(status) {
			FileManagement fm = new FileManagement(MysqlConnection.getConnection());
			//fm.add_file(1,"a", "exe", "D:\\avx", "4.5M", 1);
			//fm.add_file(2,"b", "jpg", "C:\\adsadasvx", "500KB", 2);
			//fm.add_file(3,"c", "pptx", "E:\\fasgasg", "5G", 4);
			//fm.PrintFileInfos(fm.getFile(1));
			//fm.update_file_info(1, "name", "d");
			//fm.PrintFileInfos(fm.getFile(1));
//			List<Integer> Heshs = new ArrayList<Integer>();
//			Heshs = fm.order_by("name", true);
//			for(Integer i : Heshs) {
//				fm.PrintFileInfos(fm.getFile(i));
//				System.out.println();
//			}
			fm.delete_file(1);
			fm.PrintFileInfos(fm.getFile(1));
		}
	}

}
