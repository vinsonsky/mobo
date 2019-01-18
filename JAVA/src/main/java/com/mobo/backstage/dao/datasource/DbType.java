package com.mobo.backstage.dao.datasource;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/17 17:33
 * @Description: 数据库枚举类
 */
public enum DbType {
    MASTER("master","主库"),
    SLAVE("slave","从库");

    private String type;
    private String name;

    DbType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
