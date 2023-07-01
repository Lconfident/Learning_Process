package entity;

import java.util.Date;

public class UserShow {
    // 个人信息展示UserShow
    // 姓名、工号、个人邮箱、部门、管理者、邮箱、入职日期
    private String emp_name;
    private int emp_id;
    private String emp_email;
    private String dep_name;
    private String man_name;
    private String man_email;
    private String work_years;

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getMan_name() {
        return man_name;
    }

    public void setMan_name(String man_name) {
        this.man_name = man_name;
    }

    public String getMan_email() {
        return man_email;
    }

    public void setMan_email(String man_email) {
        this.man_email = man_email;
    }

    public String getWork_years() {
        return work_years;
    }

    public void setWork_years(String work_years) {
        this.work_years = work_years;
    }
}
