package imooc.jdbc.sample;


import java.sql.*;

public class StandardJDBCSample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn  = null;
        //1.加载注册JDBC驱动
        //加载指定的JDBC驱动类，本质是通知JDBC注册这个类
        try{
            Class.forName("com.mysql.jdbc.Driver");
        //2.创建数据库连接
            //DriverManager.getConnection(url,user,password),返回Connection对象
            //
            conn = DriverManager.getConnection(
                    "jdbc:mysql://101.200.201.151:3306/imooc?user=root&password=root/",
                    "root","Ljf1996/"
            );
            //3.创建Statement对象
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee");
            //4.遍历查询结果
            while(rs.next()){
                Integer eno = rs.getInt(1);
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                System.out.println(eno+" " + ename + " " + salary +" " + dname);
            }
        }catch(Exception e){
            System.out.println(e);
        }finally {
            try{
                if(conn!=null && conn.isClosed()){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //5.关闭释放资源
    }
}
