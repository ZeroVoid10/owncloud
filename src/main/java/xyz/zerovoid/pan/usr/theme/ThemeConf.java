package xyz.zerovoid.pan.usr.theme;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONException;

public class ThemeConf {

    protected String loginBgPicPath;
    protected String logoPicPath;


    public ThemeConf(String loginBgPicPath, String logoPicPath) {
        this.loginBgPicPath = loginBgPicPath;
        this.logoPicPath = logoPicPath;
    }

    public ThemeConf() throws IOException {
        File confFile = new File("conf.json");
        JSONObject json = new JSONObject(FileUtils.readFileToString(confFile, "UTF-8"));
        this.loginBgPicPath = json.getString("loginBgPicPath");
        this.logoPicPath = json.getString("logoPicPath");
    }

    public String getLoginBgPicPath() {
        return loginBgPicPath;
    }

    public void setLoginBgPicPath(String loginBgPicPath) {
        this.loginBgPicPath = loginBgPicPath;
    }

    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }
}
