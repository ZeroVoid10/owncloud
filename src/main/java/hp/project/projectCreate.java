package hp.project;

import java.io.File;

/**
 * 项目（文件夹）创建工具类
 * @author HP
 *
 */

public class projectCreate {
	public static boolean createProject(String projectname) {
		File file=new File("C:\\Users\\HP\\Desktop\\"+projectname);
		if(!file.exists())
		{
			file.mkdir();
			return true;
		}
		else return false;
	}
}
