package FileTable;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		boolean status = new CreateTable(MysqlConnection.getConnection(), "public").create_table();
		if(status) {
			PFileManagement pfm = new PFileManagement(MysqlConnection.getConnection(), "public");
			//pfm.add_file(2,"bca", "jpg", "C:\\adsadasvx", "500KB", 2);
			//pfm.add_file(3,"abc", "pptx", "E:\\fasgasg", "5G", 4);
			//pfm.add_file(1,"cba", "exe", "D:\\avx", "4.5M", 1);
			//pfm.PrintFileInfos(pfm.getFile(1));
			//pfm.update_file_info(1, "name", "d");
			//pfm.PrintFileInfos(pfm.getFile(1));
			List<Integer> Heshs = new ArrayList<Integer>();
			Heshs = pfm.getFileList();
			Heshs = pfm.search_file(Heshs, "b");
			Heshs = pfm.order_by(Heshs, "name", false);
			for(Integer i : Heshs) {
				pfm.PrintFileInfos(pfm.getFile(i));
				System.out.println();
			}
		}
	}

}
