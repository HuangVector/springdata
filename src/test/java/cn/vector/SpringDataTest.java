package cn.vector;

import cn.vector.dao.StudentDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 8:07
 */
public class SpringDataTest {
    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        System.out.println("do setup!");
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("do tearDown!");

    }
    @Test
    public void testEntityManagerFactory(){

    }
}
