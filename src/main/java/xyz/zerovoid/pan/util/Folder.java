package xyz.zerovoid.pan.util;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import AllFileTable.*;
import xyz.zerovoid.pan.util.AppPreferences;

/**
 * @since 0.1.0
 * @author 005ssss, ZeroVoid
 */
public class Folder extends java.io.File  {
    private static final Logger logger = 
        LoggerFactory.getLogger(Folder.class);

    public Folder(String path) throws IOException {
        super(AppPreferences.getInstance().getRootPath(), path);
        if (!this.isDirectory()) {
            throw new IOException();
        }
    }

    public ArrayList<AllFileTable.File> getFileList() {
        ArrayList<AllFileTable.File> res = new ArrayList<AllFileTable.File>();
        for(File f: this.listFiles()) {
            res.add(file2file(f));
        }
        
        return res;
    }

    public AllFileTable.File file2file(java.io.File sysFile) {
        AllFileTable.File file = AllFileTable.File.getNewFile();
        file.setName(sysFile.getName())
            .setDir(sysFile.getPath())
            .setSize(getFileSize(sysFile))
            .setUpload_time(getLastModifyDate(sysFile))
            .setKind(getFileType(sysFile));
            
        return file;
    }

    public String getFileSize(File file) {
        long fileSize = file.length();
		String size;
		if(fileSize<1024) {
        	size = fileSize+"B";
        }else if(fileSize<(1024*1024)) {
        	double doublefile = (double)fileSize/1024;		        	
        	size = String.format("%.2f", doublefile) +"KB";
        }else {
        	double doublefile = (double)fileSize/1024/1024;
        	size = String.format("%.2f", doublefile) +"MB";
        }
		return size;
    }

    public String getLastModifyDate(File file) {
		Calendar cal = Calendar.getInstance();  
        long time = file.lastModified();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
        cal.setTimeInMillis(time);
        return formatter.format(cal.getTime());
    }

    public String getFileType(File file) {
        String filename = file.getName();
		String fileType=filename.substring(filename.lastIndexOf(".")+1,filename.length());
		return fileType;
    }


}
