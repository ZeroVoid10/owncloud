package FileTable;

import java.util.ArrayList;
import java.util.List;
import AllFileTable.File;

public class test {

	public static void main(String[] args) {
		boolean status = new CreateTable(MysqlConnection.getConnection(), "public").create_table();
		if(status) {
			PFileManagement pfm = new PFileManagement(MysqlConnection.getConnection(), "public");
//			pfm.add_file(2,"bca", "jpg", "C:\\adsadasvx", "500", 1, "Haibara Ai");
//			pfm.add_file(3,"abc", "pptx", "E:\\fasgasg", "50000", 4, "Miyani Shio");
//			pfm.add_file(1,"cba", "exe", "D:\\avx", "50000000", 1, "");
//			pfm.PrintFileInfos(pfm.getFile(3));
//			pfm.update_file_info(3, "tag", "");
//			pfm.PrintFileInfos(pfm.getFile(3));
			List<File> Files = new ArrayList<File>();
			Files = pfm.mult_search_file("bca", "jpg", "1", "Ai");
			for(File i : Files) {
				pfm.PrintFileInfos(i);
				System.out.println();
			}
//			pfm.delete_file(1);
//			pfm.delete_file(2);
//			pfm.delete_file(3);
		}
	}

}
