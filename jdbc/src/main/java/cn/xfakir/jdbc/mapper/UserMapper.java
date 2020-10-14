package cn.xfakir.jdbc.mapper;

import cn.xfakir.jdbc.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(rs.getInt("id"),rs.getString("name"));
        return user;
    }
}
