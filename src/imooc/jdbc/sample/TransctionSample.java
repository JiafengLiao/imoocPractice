package imooc.jdbc.sample;

import imooc.jdbc.hrapp.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransctionSample {
    public static void main(String[] args) {
        Connection conn= null;
        PreparedStatement pstmt= null;
        try {
            conn = DbUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into employee(eno,ename,salary,dname) values(?,?,?,?)";
            for(int i=1000;i<2000;i++){
//                if (i==1005){
//                    throw new RuntimeException("插入失败");
//                }
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,i);
                pstmt.setString(2,"员工"+i);
                pstmt.setFloat(3,4000);
                pstmt.setString(4,"市场部");
                pstmt.executeUpdate();
            }
            conn.commit();
        }catch (RuntimeException runtimeException){
            runtimeException.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,null,pstmt);
        }
    }
}
