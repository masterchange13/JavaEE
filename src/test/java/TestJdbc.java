import com.mao.bean.User;
import com.mao.mapper.Impl.TestJdbcDaoImpl;
import com.mao.mapper.Impl.TestMapperImpl;
import com.mao.mapper.TestJdbcDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mao
 * @description
 * @date: 2024/3/29 10:18
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


public class TestJdbc {



    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        TestJdbcDaoImpl testJdbcDao = context.getBean("testJdbcDaoImpl", TestJdbcDaoImpl.class);
        User user = new User();
        user.setU_name("测试1");
        user.setU_age(40);
        user.setU_sex("男");
        user.setU_birth("1982-03-01");
        user.setU_phone("13812345678");
        int result = testJdbcDao.addUser(user);
        System.out.println(result);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        TestJdbcDaoImpl testJdbcDao = context.getBean("testJdbcDaoImpl", TestJdbcDaoImpl.class);

        List<Object[]> users = new ArrayList<Object[]>();
        Object[] user = {"测试1", 40, "男", "13812345678", "1982-03-01"};
        Object[] user1 = {"测试2", 40, "男", "13812345678", "1982-03-01", };
        Object[] user2 = {"测试3", 40, "男", "13812345678", "1982-03-01", };

        users.add(user);
        users.add(user1);
        users.add(user2);

        int[] result = testJdbcDao.batchAddUser(users);
        for (int i = 0; i < result.length; ++i){
            if(result[i] == 0){
                System.out.println(users.get(i) + " 插入失败");
            }
        }
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        TestMapperImpl testMapper = context.getBean("testMapperImpl", TestMapperImpl.class);
        testMapper.transfer(3, 4);
    }

}
