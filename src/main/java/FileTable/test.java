package FileTable;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		boolean status = new CreateTable(MysqlConnection.getConnection(), "public").create_table();
		if(status) {
			PFileManagement pfm = new PFileManagement(MysqlConnection.getConnection(), "public");
//			pfm.add_file(2,"bca", "jpg", "C:\\adsadasvx", "500", 2);
//			pfm.add_file(3,"abc", "pptx", "E:\\fasgasg", "50000", 4);
//			pfm.add_file(1,"cba", "exe", "D:\\avx", "50000000", 1);
			//pfm.PrintFileInfos(pfm.getFile(1));
			//pfm.update_file_info(1, "name", "d");
			//pfm.PrintFileInfos(pfm.getFile(1));
			List<Integer> Heshs = new ArrayList<Integer>();
			Heshs = pfm.getFileList();
			Heshs = pfm.search_file(Heshs, "uploader_UID", "4", 1);
			for(Integer i : Heshs) {
				pfm.PrintFileInfos(pfm.getFile(i));
				System.out.println();
			}
//			pfm.delete_file(1);
//			pfm.delete_file(2);
//			pfm.delete_file(3);
		}
	}

}
