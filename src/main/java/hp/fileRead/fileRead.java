package hp.fileRead;

/**
 * 文件信息获取类，需要传入文件路径
 */

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class fileRead {
	private static String filePath = "C:\\Users\\HP\\Desktop\\UpLoad\\新建文本文档.txt";
	private static File file = new File(filePath);
	private static String fileName = file.getName();
	private static long fileByte = file.length();
	private static String fileSize;
	private static String fileDate;
	public static String getFilePath() {
		return filePath;
	}
	public static void setFilePath(String filePath) {
		fileRead.filePath = filePath;
	}
	public static File getFile() {
		return file;
	}
	public static void setFile(File file) {
		fileRead.file = file;
	}
	public static String getFileName() {
		return fileName;
	}
	public static void setFileName(String fileName) {
		fileRead.fileName = fileName;
	}
	public static long getFileByte() {
		return fileByte;
	}
	public static void setFileByte(long fileByte) {
		fileRead.fileByte = fileByte;
	}
	public static String getFileSize() {
		return fileSize;
	}
	public static void setFileSize(String fileSize) {
		fileRead.fileSize = fileSize;
	}
	public static String getFileDate() {
		return fileDate;
	}
	public static void setFileDate(String fileDate) {
		fileRead.fileDate = fileDate;
	}
	
	public static void getFileData() {
		if(fileByte<1024) {
			fileSize = fileByte+"B";
        }else if(fileByte<(1024*1024)) {
        	double doublefile = (double)fileByte/1024;		        	
        	fileSize = String.format("%.2f", doublefile) +"KB";
        }else {
        	double doublefile = (double)fileByte/1024/1024;
        	fileSize = String.format("%.2f", doublefile) +"MB";
        }
		Calendar cal = Calendar.getInstance();  
        long time = file.lastModified();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
        cal.setTimeInMillis(time);
        fileDate = formatter.format(cal.getTime());
        
	}
	
	public static void main(String[] args) {
		getFileData();
		System.out.println(fileName);
		System.out.println(fileSize);
		System.out.println(fileDate);
	}

}
