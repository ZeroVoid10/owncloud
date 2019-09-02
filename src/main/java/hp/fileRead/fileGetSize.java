package hp.fileRead;

/**
 * 转换文件大小工具类
 * @author HP
 *
 */

public class fileGetSize {
	public static String getFileSize(long fileSize) {
		String Size;
		if(fileSize<1024) {
        	Size = fileSize+"B";
        }else if(fileSize<(1024*1024)) {
        	double doublefile = (double)fileSize/1024;		        	
        	Size = String.format("%.2f", doublefile) +"KB";
        }else {
        	double doublefile = (double)fileSize/1024/1024;
        	Size = String.format("%.2f", doublefile) +"MB";
        }
		return Size;
	}

}
