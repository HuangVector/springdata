package cn.vector.domain;

/**
 * Student实体类
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-1 13:40
 */
public class Student {
    /**
     * 主键
     */
    private  Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
