package com.zhangjiajun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
    public static void main(String[] args) {
        String sql = "select * from employees where first_name = ?";
        query(sql,"Steven");
    }
    public static void query(String sql,String... params){
        Connection conn = null;
        PreparedStatement pstmt= null;
        ResultSet rs = null;
        try {
            conn = Utils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, params[0]);
            rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("员工编号:" + rs.getDouble("employee_id") +
                        "员工firstname:" + rs.getString("first_name") +
                        "员工lastname:" + rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
