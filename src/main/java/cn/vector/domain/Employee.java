package cn.vector.domain;

import javax.persistence.*;

/**
 * 雇员：首先开发实体类===>自动生成数据表
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 8:09
 */
@Entity
//@Table(name = "test_employee")
public class Employee {

    private Integer id;

    private String name;

    private Integer age;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(length = 20,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(nullable = false)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}