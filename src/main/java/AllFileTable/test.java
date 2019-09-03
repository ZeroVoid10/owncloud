package AllFileTable;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		boolean status = new CreateTable(MysqlConnection.getConnection()).create_table();
		if(status) {
			FileManagement fm = new FileManagement(MysqlConnection.getConnection());
//			fm.add_file(1,"a", "exe", "D:\\avx", "4.5M", 1, "James Fu;Haibara");
//			fm.add_file(2,"b", "jpg", "C:\\adsadasvx", "500KB", 2, "Annie Li,balabala");
//			fm.add_file(3,"c", "pptx", "E:\\fasgasg", "5G", 4, "James Fu;Shio");
//			fm.PrintFileInfos(fm.getFile(2));
//			fm.update_file_info(2, "tag", "Annie Li;balabala");
//			fm.PrintFileInfos(fm.getFile(2));
			List<File> files = new ArrayList<File>();
			files = fm.mult_search_file("a", "exe", "1", "Haibara");
			for(File i : files) {
				fm.PrintFileInfos(i);
				System.out.println();
			}
//			fm.delete_file(1);
//			fm.PrintFileInfos(fm.getFile(1));
//			fm.delete_file(1);
//			fm.delete_file(2);
//			fm.delete_file(3);
		}
	}

}
