import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.mao.bean.User;
import com.mao.mapper.UserMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: mao
 * @description
 * @date: 2024/4/7 17:54
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


public class TestMybatis {

//    读取核心配置文件
    private static InputStream config;
    static {
        try {
            config = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    根据配置文件信息构建数据库工厂对象
    private static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
    private static SqlSession sqlSession = sqlSessionFactory.openSession();

    @Test
    public void testSelecetALl(){
//        使用sqlSession ( 本身具备独立执行sq1语句的能力)对映射文件(主要是sq1语句)进行管理，并进行数据库操作
//        单独操作的方式，不使用映射文件
        List<User> list = sqlSession.selectList("com.mao.mapper.UserMapper2.selectAllUser", null, new RowBounds(0, 5));
        for (User u : list){
            System.out.println(u);
        }
    }

    @Test
    public void testSelecetALl2(){
//        使用sqlSession ( 本身具备独立执行sq1语句的能力)对映射文件(主要是sq1语句)进行管理，并进行数据库操作
//        单独操作的方式，不使用映射文件
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        List<User> users = mapper.selectAllUser();
        for (User u : users){
            System.out.println(u);
        }
    }

//   如果是进行修改，删除，添加，最后一定要提交事务
//    sqlSession.commit();
//    sqlSession.

    @Test
    public void test3(){}

}
