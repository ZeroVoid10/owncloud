package xyz.zerovoid.pan.dao;

import java.util.ArrayList;
import xyz.zerovoid.pan.dao.TableInfo;

public class TableInfo {

    private static final String prefCreateTable = 
        "create table if not exists ";

    private String tableName;
    private ArrayList<ColInfo> list;

    public TableInfo(String name) {
        tableName = name;
        list = new ArrayList<ColInfo>();
    }

    public TableInfo addColInfo(ColInfo info) {
        list.add(info);
        return this;
    }

    public String getCreateString() {
        String str = prefCreateTable + tableName + "(";
        boolean first = true;
        for(ColInfo col: list) {
            if (first) {
                str += col.build();
                first = false;
            } else {
                str += ", " + col.build();
            }
        }
        str += ");";

        return str;
    }
}
