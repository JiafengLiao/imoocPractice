package imooc.jdbc.hrapp;

import imooc.jdbc.hrapp.command.InsertCommand;
import imooc.jdbc.hrapp.command.QueryCommand;

import java.sql.SQLException;
import java.util.Scanner;

public class humanResourceApplication {
    public static void main(String[] args) throws SQLException {

//        System.out.println("1。查询部门员工");
//        QueryCommand qc = new QueryCommand();
//        qc.execute();
        InsertCommand ic = new InsertCommand();
        ic.execute();
    }
}
