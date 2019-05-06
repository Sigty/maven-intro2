package by.itacademy.database.connection;

import by.itacademy.database.util.PropertyManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConnectionPool {

    private static DataSource dataSource;

    static {
        initializeConnectionPool();
    }

    private static void initializeConnectionPool() {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName(PropertyManager.get("db.driver"));
        poolProperties.setUrl(PropertyManager.get("db.url"));
        poolProperties.setUsername(PropertyManager.get("db.user"));
        poolProperties.setPassword(PropertyManager.get("db.password"));
        poolProperties.setMaxActive(Integer.parseInt(PropertyManager.get("db.pool.size")));
        dataSource = new DataSource(poolProperties);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
