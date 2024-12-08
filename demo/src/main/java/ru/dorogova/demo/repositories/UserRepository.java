package ru.dorogova.demo.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.dorogova.demo.model.User;
import ru.dorogova.demo.utils.UserMapper;

import java.util.List;

/**
 * Репозиторий для запросов к БД сущности пользователей
 */
@Repository
public class UserRepository {

    /**
     * Объект подключения к БД
     */
    private final JdbcTemplate jdbc;

    /**
     * Конструктор класса
     * @param jdbc
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Получение всех пользователей из базы данных
    public List<User> findAll(){
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastname"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    //Добавление в базу данных
    public User save(User user){
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";//"INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Удаление пользователя из базы по id
     * @param id
     */
    public void delete(int id){
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Обновление пользователя в БД
     * @param user объект пользователя с измененными данными
     */
    public void update(User user){
        String sql = "UPDATE userTable SET firstName = ?, lastname = ? WHERE id=?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }

    /**
     * Поиск пользователя по id
     * @param id
     * @return
     */
    public User findUserById(Integer id){
        String sql = "SELECT * FROM userTable WHERE id=?";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastname"));
            return rowObject;
        };
        return jdbc.query(sql, new Object[]{id}, new UserMapper())
                .stream().findFirst().orElse(null);
    }
}


