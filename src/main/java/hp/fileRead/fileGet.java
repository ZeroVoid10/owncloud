package hp.fileRead;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件读取类，列表存储
 * @author HP
 *
 */

public class fileGet {
	private static String projectPath;
	private static List<String> nameList = new ArrayList<String>();
	private static List<String> sizeList = new ArrayList<String>();
	private static List<String> dateList = new ArrayList<String>();
	private static List<String> pathList = new ArrayList<String>();
	private static List<String> typeList = new ArrayList<String>();
	private static List<String> changeList = new ArrayList<String>();
	
	public static List<String> getPathList() {
		return pathList;
	}
	public static void setPathList(List<String> pathList) {
		fileGet.pathList = pathList;
	}
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
	
	public static String getprojectPath() {
		return projectPath;
	}
	public static void setprojectPath(String projectPath) {
		fileGet.projectPath = projectPath;
	}
	public static List<String> getTypeList() {
		return typeList;
	}
	public static void setTypeList(List<String> typeList) {
		fileGet.typeList = typeList;
	}
	public static List<String> getChangeList() {
		return changeList;
	}
	public static void setChangeList(List<String> changeList) {
		fileGet.changeList = changeList;
	}
	public static void getFileName() {
		File file = new File(projectPath);
		File[] fileList = file.listFiles();
		List<File> wjList = new ArrayList<File>();
		List<String> namelist = new ArrayList<String>();
		List<String> sizelist = new ArrayList<String>();
		List<String> datelist = new ArrayList<String>();
		List<String> pathlist = new ArrayList<String>();
		List<String> typelist = new ArrayList<String>();
		List<String> changelist = new ArrayList<String>();
		for (int i = 0; i < fileList.length; i++) {
		   if (fileList[i].isFile()) {
		        wjList.add(fileList[i]);
		        String name = fileList[i].getName();
		        String path = fileList[i].getPath();
		        String Size = null;
		        String type = fileGetType.getFileType(name);
		        String change = fileTypeChange.changeType(type);
		        long fileSize = fileList[i].length();
		        Size = fileGetSize.getFileSize(fileSize);
		        String Date = fileGetDate.getFileDate(fileList[i]); 
		        System.out.println(type + name +"    "+ Size +"    "+ Date);
		        namelist.add(name);
		        sizelist.add(Size);
		        datelist.add(Date);
		        pathlist.add(path);
		        typelist.add(type);
		        changelist.add(change);
		   }
		}
		nameList = namelist;
        sizeList = sizelist;
        dateList = datelist;
        pathList = pathlist;
        typeList = typelist;
        changeList = changelist;
	}
	
	public static void main(String[] args) {
		getFileName();
		System.out.println(changeList);
	}

}
