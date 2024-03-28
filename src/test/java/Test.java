import com.mao.bean.User;
import com.mao.mapper.Impl.TestJdbcDaoImpl;
import com.mao.mapper.Impl.TestMapperImpl;
import com.mao.mapper.Impl.UserMapperImpl;
import com.mao.mapper.Impl.UserMapperImpl2;
import com.mao.mapper.UserMapper;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: mao
 * @description
 * @date: 2024/3/28 10:30
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        System.out.println("hello world");
    }

    @org.junit.jupiter.api.Test
    public void testUser() {
        User user = new User();
        System.out.println(user.getU_id());
    }

    @org.junit.jupiter.api.Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user1", User.class);
        user.setU_name("zhangyq");
        System.out.println(user.getU_sex());
        System.out.println(user.getU_name());
    }

    @org.junit.jupiter.api.Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapperProxy1", UserMapper.class);
        userMapper.add();
        userMapper.delete();
        userMapper.modify();
        userMapper.show();

    }

    @org.junit.jupiter.api.Test
    public void testAOP(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapperImpl2 userMapperProxy2 = context.getBean("userMapperImpl2", UserMapperImpl2.class);
        userMapperProxy2.add();
    }

    @org.junit.jupiter.api.Test
    public void testAOP2(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userMapperProxy2 = context.getBean("userMapperProxy2", UserMapperImpl2.class);
//        userMapperProxy2
    }

    @org.junit.jupiter.api.Test
    public void testAOP3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserMapperImpl2 userMapperProxy2 = context.getBean("userMapper2", UserMapperImpl2.class);
        userMapperProxy2.add();
        userMapperProxy2.delete();
        userMapperProxy2.show();
        userMapperProxy2.modify();
    }

    @org.junit.jupiter.api.Test
    public void testAOP4(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop2.xml");
        TestMapperImpl testMapperImpl = context.getBean("testMapperImpl", TestMapperImpl.class);
        testMapperImpl.add();
    }

    @org.junit.jupiter.api.Test
    public void Test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        TestJdbcDaoImpl testJdbcDaoImpl = context.getBean("testJdbcDaoImpl", TestJdbcDaoImpl.class);
        List<User> userList = testJdbcDaoImpl.selectAllUser();
        for (User user: userList){
            System.out.println(user.getU_name());
        }


    }
}
