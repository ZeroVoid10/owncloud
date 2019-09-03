package hp.fileRead;

import java.io.File;

/**
 * 文件信息获取类，需要传入文件路径
 * @author HP
 *
 */

public class fileRead {
	private static String filePath = "C:\\Users\\HP\\Desktop\\UpLoad\\新建文本文档.txt";
	private static File file = new File(filePath);
	private static String fileName = file.getName();
	private static long fileByte = file.length();
	private static String fileSize = fileGetSize.getFileSize(fileByte);
	private static String fileDate = fileGetDate.getFileDate(file);
	private static String fileType = fileGetType.getFileType(fileName);
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
	public static String getFileType() {
		return fileType;
	}
	public static void setFileType(String fileType) {
		fileRead.fileType = fileType;
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
	
	public static void main(String[] args) {
		System.out.println(fileName);
		System.out.println(fileSize);
		System.out.println(fileDate);
		System.out.println(fileType);
	}

}
