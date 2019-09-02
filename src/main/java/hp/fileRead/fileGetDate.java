package hp.fileRead;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 获取文件修改时间工具类
 * @author HP
 *
 */

public class fileGetDate {
	public static String getFileDate(File file) {
		String fileDate;
		Calendar cal = Calendar.getInstance();  
        long time = file.lastModified();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
        cal.setTimeInMillis(time);
        return fileDate = formatter.format(cal.getTime());
	}

}
