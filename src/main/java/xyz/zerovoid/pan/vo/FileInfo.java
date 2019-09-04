package xyz.zerovoid.pan.vo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * 前端展示文件类
 * @since 0.1.0
 * @author James
 */
public class FileInfo {
    private int hash;
    private String realPath;
    private String panPath;

    private String type;
    private float size;
    private User user;
    private Date uploadTime;
    private String projecet;
    private ArrayList<String> tags;
    
    public FileInfo(String realPath, String panPath) {
        this.realPath = realPath;
        this.panPath = panPath;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int gethash() {
        return hash;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setPanPath(String panPath) {
        this.panPath = panPath;
    }

    public String getPanPath() {
        return panPath;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getSize() {
        return size;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }



}
