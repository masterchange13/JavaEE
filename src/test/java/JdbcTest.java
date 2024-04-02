import com.mao.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.thymeleaf.standard.expression.GreaterThanExpression;

import java.util.List;

@Component
public class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public List<User> test(){
        String sql = "select * from user";
        List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(result);
        return result;
    }

    @Test
    public void test1(){
        System.out.println("hello world");
    }
}
