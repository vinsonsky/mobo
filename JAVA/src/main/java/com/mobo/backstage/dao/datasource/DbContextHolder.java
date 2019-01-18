package com.mobo.backstage.dao.datasource;


/**
 * @Auther: chengyunyi
 * @Date: 2019/1/17 17:37
 * @Description: 数据库切换
 */
public class DbContextHolder {

    private static final ThreadLocal<String> LOCAL=new ThreadLocal<>();

    public static void setDbType(DbType dbType){
        if (dbType==null) throw new NullPointerException();
        LOCAL.set(dbType.getType());
    }

    public static String getDbType(){
        return LOCAL.get()==null?DbType.MASTER.getType():LOCAL.get();
    }

    public static void clearDbType(){
        LOCAL.remove();
    }

}
