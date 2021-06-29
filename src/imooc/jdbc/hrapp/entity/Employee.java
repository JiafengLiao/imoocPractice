package imooc.jdbc.hrapp.entity;

import java.util.Date;

public class Employee {
    public Employee(){};

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    private Integer eno;
    private String ename;
    private Float salary;
    private String dname;
    private Date hireData;

    public Date getHireData() {
        return hireData;
    }

    public void setHireData(Date hireData) {
        this.hireData = hireData;
    }

}
