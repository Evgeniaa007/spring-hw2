package ru.dorogova.demo.utils;

import org.springframework.jdbc.core.RowMapper;
import ru.dorogova.demo.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер сущности пользователя, для преобразования данных и БД в сущность.
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastname"));
        return user;
    }
}

