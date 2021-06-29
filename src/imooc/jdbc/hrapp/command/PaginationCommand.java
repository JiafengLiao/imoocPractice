package imooc.jdbc.hrapp.command;

import imooc.jdbc.hrapp.common.DbUtils;
import imooc.jdbc.hrapp.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PaginationCommand implements Command{

    @Override
    public void execute(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入页号");
        int page = in.nextInt();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<>();
        try {
            conn = DbUtils.getConnection();
            String sql = "select * from employee limit ?,10";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, page-1*10);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Integer eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                Date hireDate = rs.getDate("hireDate");
                Employee emp = new Employee();
                emp.setEno(eno);
                emp.setEname(ename);
                emp.setSalary(salary);
                emp.setDname(dname);
                emp.setHireData(hireDate);
                list.add(emp);
            }
            System.out.println(list.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeConnection(conn,rs,pstmt);
        }
    }
}
