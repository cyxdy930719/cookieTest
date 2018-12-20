package com.neuedu.untiltest;
import com.mysql.jdbc.Driver;
import com.neuedu.untiltest.RowMap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUntil {
    static{
        try {
            new Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/s_t?useUnicode=true&characterEncoding=utf8";
    public static final String USER = "root";
    public static final String PWD = "1234";
    //创建连接
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭
    public static void close(ResultSet rs, PreparedStatement pstmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //定义增删改
    public static int executeUpdate(String sql,Object... obj){
        int a=0;
        Connection conn=null;
        PreparedStatement pstmt=null;
        conn=getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            if (obj!=null){
                for(int i=0;i<obj.length;i++){
                    pstmt.setObject(i+1,obj[i]);
                }
            }
            a=pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null,pstmt,conn);
        }
        return a;
    }
    //定义查询
    public static <T>List<T> executeQuery(String sql, RowMap<T> rm, Object... obj){
        List<T> lists = new ArrayList<>();
        Connection conn=null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn=getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            if (obj!=null){
                for (int i=0;i<obj.length;i++){
                    pstmt.setObject(i+1,obj[i]);
                }
            }
            rs=pstmt.executeQuery();
            while(rs.next()){
                T t=rm.RowMapping(rs);
                lists.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,pstmt,conn);
        }
        return lists;
    }
    public static <T>T QueryOne(String sql, RowMap<T> rm,Object... obj){
        T t = null;
        Connection conn=null;
        PreparedStatement pstmt = null;
        conn=getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            if (obj!=null){
                for (int i=0;i<obj.length;i++){
                    pstmt.setObject(i+1,obj[i]);
                }
            }
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                t=rm.RowMapping(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> int executeCount(String sql,Object... obj){
        int a = 0;
        Connection conn=null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn=getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (obj!=null){
                for(int i = 0;i<obj.length;i++){
                    pstmt.setObject(i+1,obj[i]);
                }
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                a =rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


}
