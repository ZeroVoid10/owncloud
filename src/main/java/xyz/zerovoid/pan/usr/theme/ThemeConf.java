package xyz.zerovoid.pan.usr.theme;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import org.json.JSONObject;
import org.json.JSONException;
import org.apache.commons.io.*;

public class ThemeConf {

    protected static final String loginBackground = "loginBackground";
    protected static final String loginLogo = "loginLogo";
    protected static final String confgPath = "xyz/zerovoid/pan/usr/theme/conf.json";

    protected JSONObject themeConfData;

    protected volatile static ThemeConf instance;

    protected ThemeConf() throws IOException {
        File confFile = new File(confgPath);
        String temp = FileUtils.readFileToString(confFile, "UTF-8");
        this.themeConfData = new JSONObject(temp);
    }

    public static ThemeConf getInstance() throws IOException {
        if (instance == null) {
            synchronized (ThemeConf.class) {
                if (instance == null) {
                    instance = new ThemeConf();
                }
            }
        }
        return instance;
    }

    protected void updata() throws JSONException, IOException {
        FileWriter writer = new FileWriter(confgPath);
        themeConfData.write(writer);
        writer.close();
    }

    public String getLoginBackground() {
        return themeConfData.getString(loginBackground);
    }

    public boolean setLoginBackground(String path) {
        themeConfData.put(loginBackground, path);
        try {
			updata();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
            return false;
		}
        return true;
    }

    public String getLoginLogo() {
        return themeConfData.getString(loginLogo);
    }

    public boolean setLoginLogo(String path) {
        themeConfData.put(loginLogo, path);
        try {
			updata();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
            return false;
		}
        return true;
    }

    public static void main(String[] args) throws IOException {
        ThemeConf ins = ThemeConf.getInstance();
        System.out.println(ins.getLoginLogo());
        System.out.println(ins.getLoginBackground());
        ins.setLoginLogo("test.png");
        System.out.println(ins.getLoginLogo());
    }
}
