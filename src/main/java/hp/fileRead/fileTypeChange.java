package hp.fileRead;

/**
 * 文件类型转换工具类
 * @author HP
 *
 */

public class fileTypeChange {
	public static String changeType(String type) {
		if(type.equals("doc")||type.equals("docx")) {
			type= "doc";
		}
		else if(type.equals("txt")) {
			type="txt";
		}
		else if(type.equals("rar")) {
			type="rar";
		}
		else if(type.equals("zip")) {
			type="zip";
		}
		else if(type.equals("pdf")) {
			type="pdf";
		}
		else if(type.equals("ppt")||type.equals("pptx")) {
			type="ppt";
		}
		else if(type.equals("xls")||type.equals("xlsx")) {
			type="xls";
		}
		else if(type.equals("jpg")||type.equals("png")||type.equals("gif")||type.equals("jpeg")) {
			type="jpg";
		}
		else {
			type="other";
		}
		return type;
	}
	public static void main(String[] args) {
		String type = "";
		type=changeType(type);
		System.out.println(type);
	}

}
