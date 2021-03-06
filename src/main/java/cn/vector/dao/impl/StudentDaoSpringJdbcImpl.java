package cn.vector.dao.impl;

import cn.vector.dao.StudentDao;
import cn.vector.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDao访问接口实现类：通过Spring jdbc的方式操作
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-1 15:19
 */
public class StudentDaoSpringJdbcImpl implements StudentDao{
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<Student> query() {
       final List<Student> students = new ArrayList<Student>();
         String sql = "select id, name, age from student";
         jdbcTemplate.query(sql, new RowCallbackHandler() {
             @Override
             public void processRow(ResultSet rs) throws SQLException {
                 int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Student student= new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
             }
         });
        return students;
    }

    @Override
    public void save(Student student) {
        String sql = "insert into student (name, age) values (?, ?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
