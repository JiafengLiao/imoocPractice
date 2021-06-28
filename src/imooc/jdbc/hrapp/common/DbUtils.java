package imooc.jdbc.hrapp.common;

import java.sql.*;

public class DbUtils {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://101.200.201.151:3306/imooc?user=root&password=root/",
                "root","Ljf1996/"
        );
        return conn;
    }

    public static  void closeConnection(Connection conn, ResultSet rs, Statement st){

        try {
            if(rs!=null){
                rs.close();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        try{
            if(st!=null){
                st.close();
            }
        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
