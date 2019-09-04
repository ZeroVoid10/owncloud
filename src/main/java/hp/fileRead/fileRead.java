package hp.fileRead;

import java.io.File;

/**
 * 文件信息获取类，需要传入文件路径
 * @author HP
 *
 */

public class fileRead {
	private static String filePath;
	private static File file;
	private static String fileName;
	private static long fileByte;
	private static String fileSize;
	private static String fileDate;
	private static String fileType;
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
	public static void getFileData() {
		file = new File(filePath); 
		fileName = file.getName();
		fileByte = file.length();
		fileSize = fileGetSize.getFileSize(fileByte);
		fileDate = fileGetDate.getFileDate(file);
		fileType = fileGetType.getFileType(fileName);
	}
	
	public static void main(String[] args) {
		setFilePath("C:\\Users\\HP\\Desktop\\UpLoad\\1808.01244.pdf");
		getFileData();
		System.out.println(fileName);
		System.out.println(fileSize);
		System.out.println(fileDate);
		System.out.println(fileType);
	}

}
