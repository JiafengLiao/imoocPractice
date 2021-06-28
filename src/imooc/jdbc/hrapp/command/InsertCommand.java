package imooc.jdbc.hrapp.command;

import imooc.jdbc.hrapp.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertCommand implements Command{
    @Override
    public void execute(){
        Scanner in = new Scanner(System.in);
        int eno = in.nextInt();
        String ename = in.next();
        Float salary = in.nextFloat();
        String dname = in.next();
        Connection conn=null;
        ResultSet rs = null;
//        Statement stmt = null;
        PreparedStatement ps =null;
        try {
            conn = DbUtils.getConnection();
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery("select * from employee where dname='"+pdname+"'");
            String sql = "insert into employee(eno,ename,salary,dname) value(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,eno);
            ps.setString(2,ename);
            ps.setFloat(3,salary);
            ps.setString(4,dname);
            int cnt = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,rs,ps);
        }
    }
}
