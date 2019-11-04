package com.hza.entity;

/**
 * Create by hza
 * 2019-11-04 18:23
 *    sn                   char(5) not null,
 *    password             varchar(20),
 *    name                 varchar(20),
 *    department_sn        char(5),
 *    post                 varchar(20),
 */
public class Employee {

    private String sn ;             // 员工编号
    private String password ;       // 密码
    private String name ;           // 姓名
    private String departmentSn ;   // 部门编号
    private String post ;           // 职位

    private Department department ;

    public Employee() {
    }

    public Employee(String sn, String password, String name, String departmentSn, String post) {
        this.sn = sn;
        this.password = password;
        this.name = name;
        this.departmentSn = departmentSn;
        this.post = post;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentSn() {
        return departmentSn;
    }

    public void setDepartmentSn(String departmentSn) {
        this.departmentSn = departmentSn;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "sn='" + sn + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", departmentSn='" + departmentSn + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
