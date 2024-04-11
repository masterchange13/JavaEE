import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.mao.bean.Skill;
import com.mao.bean.User;
import com.mao.mapper.SkillMapper;
import com.mao.mapper.UserMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    @Test
    public void test5(){
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        User user = new User();
        user.setU_name("飞猪");
        user.setU_age(20);
        user.setU_sex("m");
        user.setU_phone("1234567890");
        user.setU_birth("2024-04-07");
        int res = mapper.insertIntoUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6(){
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        User user = new User();
        user.setU_name("飞猪");
        user.setU_age(20);
        user.setU_sex("m");
        user.setU_phone("1234567890");
        user.setU_birth("2024-04-07");
        List<User> users = mapper.selectUserByUserInfo(user);
        for (User u : users){
            System.out.println(u);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test7(){
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        User user = new User();
        user.setU_name("飞猪");
        user.setU_age(20);
        user.setU_sex("m");
        user.setU_phone("1234567890");
        user.setU_birth("2024-04-07");
        List<User> users = mapper.selectUserByUserInfo2(user);
        for (User u : users){
            System.out.println(u);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test8(){
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        User user = new User();
        user.setU_id(1);
        user.setU_name("小猪猪");
        user.setU_age(20);
        user.setU_sex("m");
        user.setU_phone("1234567890");
        user.setU_birth("2024-04-07");
        int i = mapper.updateUser(user);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test9(){
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        User user = new User();
        user.setU_name("飞猪");
        user.setU_age(20);
        user.setU_sex("m");
        user.setU_phone("1234567890");
        user.setU_birth("2024-04-07");
        List<User> users = mapper.selectUserByUserInfo6(user);
        for (User u : users){
            System.out.println(u);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test10(){
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<User> users = mapper.selectUserByIds(ids);
        for (User u : users){
            System.out.println(u);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test11(){
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < 3; ++i){
            User user = new User();
            user.setU_name("测试" + i);
            user.setU_age(20);
            user.setU_sex("m");
            user.setU_phone("1234567890");
            user.setU_birth("2024-04-07");
            users.add(user);
        }
        Integer result = mapper.insertIntoUser2(users);
        System.out.println(result);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test12(){
        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);

        List<User> users = mapper.selectUserSkill(1);
        for (User u: users){
            System.out.println(u);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test14(){
        SkillMapper mapper = sqlSession.getMapper(SkillMapper.class);

        List<Skill> users = mapper.selectAllSkill(1);
        for (Skill u: users){
            System.out.println(u);
        }

        sqlSession.commit();
        sqlSession.close();
    }



}
