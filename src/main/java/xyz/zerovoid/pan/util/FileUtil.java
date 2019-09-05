package xyz.zerovoid.pan.util;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import AllFileTable.File;

/**
 * @since 0.1.0
 * @author 005ssss, ZeroVoid
 */
public class FileUtil {
    private static final Logger logger = 
        LoggerFactory.getLogger(FileUtil.class);

    private String path;
    private ArrayList<File> fileList;

    public FileUtil(String path) {
        this.path = path;
        fileList = new ArrayList<File>();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }

    public String getFileName() {
    }

}
