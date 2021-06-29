package imooc.jdbc.sample;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import imooc.jdbc.hrapp.entity.Employee;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;

public class DbUtilsSample {
    private static void query(){
        Properties properties = new Properties();
        String propertyFile = DruidSimple.class.getResource("/druid-config.properties").getPath();
        try {
            propertyFile = new URLDecoder().decode(propertyFile,"UTF-8");
            properties.load(new FileInputStream(propertyFile));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            QueryRunner qr = new QueryRunner(dataSource);
            List<Employee> list = qr.query("select * from employee limit ?,10",
                    new BeanListHandler<>(Employee.class),
                    new Object[]{10});
            for(Employee emp : list){
                System.out.println(emp.getEname());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        query();
    }
}
