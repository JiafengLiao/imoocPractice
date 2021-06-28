package imooc.jdbc.hrapp.command;

import imooc.jdbc.hrapp.common.DbUtils;

import java.sql.*;
import java.util.Scanner;

public class QueryCommand implements Command{
    @Override
    public void execute() throws SQLException {
        System.out.println("Input dname");
        Scanner in = new Scanner(System.in);
        String pdname = in.next();
        Connection conn=null;
        ResultSet rs = null;
//        Statement stmt = null;
        PreparedStatement ps =null;
        try {
            conn = DbUtils.getConnection();
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery("select * from employee where dname='"+pdname+"'");
            String sql = "select * from employee where dname=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,pdname);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("eno")+" "+ rs.getString("ename") + " " +
                        rs.getFloat("salary") + " " + rs.getString("dname"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,rs,ps);
        }
    }
}
