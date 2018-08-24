package cn.vector.utils;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-1 9:44
 */
public class JDBCUtilTest {

    @Test
    public void getConection() throws Exception {
        Connection connection = JDBCUtil.getConection();
        Assert.assertNotNull(connection);
    }
    @Test
    public void release(ResultSet resultSet,
                               Statement statement,
                               Connection connection){

    }

}