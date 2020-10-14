package cn.xfakir.jdbc.service;

import cn.xfakir.jdbc.entity.User;
import cn.xfakir.jdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user_tb(name) values(?)", user.getName(),new int[]{
                Types.VARCHAR
        });
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from user_tb", new UserMapper());
    }
}
