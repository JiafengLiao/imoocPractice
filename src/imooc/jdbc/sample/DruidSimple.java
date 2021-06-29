package imooc.jdbc.sample;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidSimple {
    public static void main(String[] args) {
        //1.加载属性
        Properties properties = new Properties();
        String propertyFile = DruidSimple.class.getResource("/druid-config.properties").getPath();
        try {
            propertyFile = new URLDecoder().decode(propertyFile,"UTF-8");
            properties.load(new FileInputStream(propertyFile));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2。获取DataSource数据源对象
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            for(int i=0;i<21;i++){
                conn = dataSource.getConnection();
            }
//            conn = dataSource.getConnection();
            String sql = "select * from employee limit 0,10";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Integer eno = rs.getInt(1);
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                System.out.println(eno+" " + ename + " " + salary +" " + dname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(conn!=null && conn.isClosed()){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //3。获取数据库类连接
    }
}
