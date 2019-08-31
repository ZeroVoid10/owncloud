package hp.fileRead;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class fileGet {
	private static String filePath = "C:\\Users\\HP\\Desktop\\UpLoad";
	private static File file = new File(filePath);
	private static File[] fileList = file.listFiles();
	private static List<String> nameList = new ArrayList<String>();
	private static List<String> sizeList = new ArrayList<String>();
	private static List<String> dateList = new ArrayList<String>();
	
	public static List<String> getNameList() {
		return nameList;
	}
	public static void setNameList(List<String> nameList) {
		fileGet.nameList = nameList;
	}
	public static List<String> getSizeList() {
		return sizeList;
	}
	public static void setSizeList(List<String> sizeList) {
		fileGet.sizeList = sizeList;
	}
	public static List<String> getDateList() {
		return dateList;
	}
	public static void setDateList(List<String> dateList) {
		fileGet.dateList = dateList;
	}
	
	public static void getFileName() {
		List<File> wjList = new ArrayList<File>();//�½�һ���ļ�����
		for (int i = 0; i < fileList.length; i++) {
		   if (fileList[i].isFile()) {//�ж��Ƿ�Ϊ�ļ�
		        wjList.add(fileList[i]);
		        String name = fileList[i].getName();
		        String Size = null;
		        long fileSize = fileList[i].length();
		        if(fileSize<10240) {
		        	Size = fileSize+"B";
		        }else if(fileSize<(10240*1024)) {
		        	Size = fileSize/1024+"KB";
		        }else {
		        	Size = fileSize/1024/1024+"MB";
		        }
		        Calendar cal = Calendar.getInstance();  
		        long time = fileList[i].lastModified();  
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
		        cal.setTimeInMillis(time);    
		        System.out.println(name+"    "+ Size +"    "+ formatter.format(cal.getTime()));
		        nameList.add(name);
		        sizeList.add(Size);
		        dateList.add(formatter.format(cal.getTime()));
		   }
		}
	}
	public static void main(String[] args) {
		getFileName();
		System.out.println(nameList);
		System.out.println(dateList);
	}

}