package com.klu.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptid")
    private int deptid;

    @Column(name = "deptname")
    private String deptname;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public int getDeptId() {
        return deptid;
    }

    public void setDeptId(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptName() {
        return deptname;
    }

    public void setDeptName(String deptname) {
        this.deptname = deptname;
    }
}
