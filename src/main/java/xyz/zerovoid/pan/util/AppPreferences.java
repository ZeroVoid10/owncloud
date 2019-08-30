package xyz.zerovoid.pan.util;

import java.util.prefs.Preferences;

/**
 * 应用配置设置。主要放置安装时相关配置内容。
 * @since 0.1.0
 */
public class AppPreferences {

    private Preferences pref = Preferences.userNodeForPackage(AppPreferences.class);

    private volatile static AppPreferences instance;

    public static AppPreferences getInstance() {
        if (instance == null) {
            synchronized (AppPreferences.class) {
                if (instance == null) {
                    instance = new AppPreferences();
                }
            }
        }
        return instance;
    }

    public void setCredentials(String username, String password) {
        pref.put("db_username", username);
        pref.put("db_password", password);
    }

    public void setHost(String host) {
        pref.put("db_host", host);
    }

    public void setPort(String port) {
        pref.put("db_port", port);
    }

    public void setDBDriver(String driver) {
        pref.put("db_driver", driver);
    }

    public void setDabaseName(String name) {
        pref.put("db_name", name);
    }

    public String getUsername() {
        return pref.get("db_username", null);
    }

    public String getPassword()  {
        return pref.get("db_password", null);
    }

    public String getHost() {
        return pref.get("db_host", null);
    }

    public String getPort() {
        return pref.get("db_port", null);
    }

    public String getDatabaseName() {
        return pref.get("db_name", null);
    }

    public String getDBDriver() {
        return pref.get("db_driver", null);
    }
}
