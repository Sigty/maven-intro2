package by.itacademy.database.dao;

import by.itacademy.database.connection.ConnectionPool;
import by.itacademy.database.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    private static final String FIND_ALL_USERS = "SELECT id, firstname, secondname FROM schema_kd.user";

    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_USERS);
            while (resultSet.next()) {
                User user = getUserFromResultSet(resultSet);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getInt("id"))
                .firstName(resultSet.getString("firstname"))
                .secondName(resultSet.getString("secondname"))
                .build();
    }

    public static UserDao getInstance() {

        return INSTANCE;
    }

}

