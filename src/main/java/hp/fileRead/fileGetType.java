package hp.fileRead;

public class fileGetType {
	public static String getFileType(String filename) {
		String fileType=filename.substring(filename.lastIndexOf(".")+1,filename.length());
		return fileType;
	}

}
