1)创建Maven项目
    maven工程的目录结构
    获取依赖
        <!-- MySql Driver -->
            <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.38</version>
            </dependency>
        <!-- Junit测试 -->
            <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>4.11</version>
              <scope>test</scope>
            </dependency>
2)数据表的准备
create database spring_data character set utf8 ;

create table student(
id int not null auto_increment,
name varchar(20) not null,
age int not null,
primary key(id)
) character set utf8;
insert into student (name, age) values ("张三",20);
insert into student (name, age) values ("李四",21);
insert into student (name, age) values ("王五",22);
#常用命令
use spring_data;
show tables;
desc student;

3)开发JDBCUtil工具类
获取Connection,关闭Connection,Statement,ResultSet

注意事项：配置的属性放在配置文件中，然后通过代码的方式将配置文件中的数据加载进来即可。

4)建立对象模型， DAO

使用Spring jdbc的方式操作数据库
1）添加依赖
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>4.3.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.3.5.RELEASE</version>
        </dependency>
2）配置beans.xml
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="username" value="spring_data"/>
        <property name="password" value="123456"/>
        <property name="url" value="jdbc:mysql:///spring_data"/>
    </bean>
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <bean id="studentDao" class="cn.vector.dao.impl.StudentDaoSpringJdbcImpl">
        <property name="jdbcTemplate" ref="jdbcTemplate"/>
    </bean>
3）开发spring jdbc版本的query和save




