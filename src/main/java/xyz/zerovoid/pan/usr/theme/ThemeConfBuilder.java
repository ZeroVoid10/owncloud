package xyz.zerovoid.pan.usr.theme;

public class ThemeConfBuilder {

    protected String loginBgPicPath;
    protected String logoPicPath;

    private volatile static ThemeConfBuilder instance;

    private ThemeConfBuilder() {

    }

    public static ThemeConfBuilder getBuilder() {
        if (instance == null) {
            synchronized (ThemeConfBuilder.class) {
                if (instance == null) {
                    instance = new ThemeConfBuilder();
                }
            }
        }
        return instance;
    }

    public ThemeConf build() {
        return new ThemeConf(loginBgPicPath, logoPicPath);
    }
    
    public ThemeConfBuilder setLoginBgPicPath(String loginBgPicPath) {
        this.loginBgPicPath = loginBgPicPath;
        return this;
    }

    public ThemeConfBuilder setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
        return this;
    }

}
