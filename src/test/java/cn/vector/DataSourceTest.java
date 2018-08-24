package cn.vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-1 15:00
 */
public class DataSourceTest {
    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        System.out.println("do setup!");
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("do tearDown!");

    }

    @Test
    public void testDataSource() {
        System.out.println("do testDataSource!");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.notNull(dataSource);
    }
     @Test
    public void testJdbcTemplate() {
        System.out.println("do testJdbcTemplate!");
         JdbcTemplate jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.notNull(jdbcTemplate);
    }
}
