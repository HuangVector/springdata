Repository类的定义
public interface Repository<T, ID extends Serializable> {

}
1）Repository是一个空接口，标记接口
没有包含方法声明的接口

2）如果我们定义的接口EmployeeRepository extends Repository

如果我们自己的接口没有extends Repository, 运行时会报错
org.springframework.beans.factory.NoSuchBeanDefinitionException:
    No qualifying bean of type 'cn.vector.repository.EmployeeRepository' available

3）添加注解可以不用extends Repository，也能使用Repository相应的功能
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)