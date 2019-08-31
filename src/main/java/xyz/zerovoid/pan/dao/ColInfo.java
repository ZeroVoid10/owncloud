package xyz.zerovoid.pan.dao;

public class ColInfo {
    private String name;
    private String type;
    private int typeLength;
    private boolean isKey;
    private boolean isNotNull;
    private String defaultValue;
    private String other;

    public ColInfo(String name, String type) {
        this.name = name;
        this.type = type;
        this.typeLength = 0;
        this.isKey = false;
        this.isNotNull = false;
        this.defaultValue = "";
        this.other = "";
    }

    public ColInfo(String name, String type, int typeLength,
            boolean isKey, boolean isNotNull) {
        this.name = name;
        this.type = type;
        this.typeLength = typeLength;
        this.isKey = isKey;
        this.isNotNull = isNotNull;
        this.defaultValue = "";
        this.other = "";
    }

    public ColInfo setName(String name) {
        this.name = name;
        return this;
    }

    public ColInfo setType(String type) {
        this.type = type;
        return this;
    }

    public ColInfo setTypeLength(int typeLength) {
        this.typeLength = typeLength;
        return this;
    }

    public ColInfo setIsKey(boolean isKey) {
        this.isKey = isKey;
        return this;
    }

    public ColInfo setIsNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
        return this;
    }

    public ColInfo setDefaultValue(String defaultValue) {
        this.defaultValue = " default '" + defaultValue + "'";
        return this;
    }

    public ColInfo setOther(String other) {
        this.other = " " + other;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getTypeLength() {
        return typeLength;
    }

    public boolean getIsKey() {
        return isKey;
    }

    public boolean getIsNotNull() {
        return isNotNull;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getOther() {
        return other;
    }

    public String build() {
        return name+" " + getTypeString() + " " + getKeyString() + " " +
                getLimit() + defaultValue + " " + other;
    }

    public String getTypeString() {
        if (typeLength == 0) {
            return type;
        } else {
            return type + "(" + Integer.toString(typeLength) + ")";
        }
    }

    public String getKeyString() {
        return (isKey)? "primary key":"";
    }

    public String getLimit() {
        return (isNotNull)? "not null":"";
    }
}
