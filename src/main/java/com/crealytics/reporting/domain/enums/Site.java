package com.crealytics.reporting.domain.enums;


public enum Site {

    IOS("iOS"),

    ANDROID("android"),

    DESKTOP_WEB("desktop web"),

    DESKTOP_MOBILE("mobile web");

    String value;

    Site(String value){
        this.value = value;
    }

    public static Site of(String site) throws Exception {
        switch (site){
            case "ios": return IOS;
            case "android": return ANDROID;
            case "desktop_web":
            case "desktop web":
                return DESKTOP_WEB;
            case "mobile web":
            case "mobile_web":
                return DESKTOP_MOBILE;

            default: throw new Exception("Invalid value for site: " + site);
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
