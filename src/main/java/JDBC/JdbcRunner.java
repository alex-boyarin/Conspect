package JDBC;

import JDBC.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
        String tableInfo = """
                CREATE TABLE IF NOT EXISTS info (
                id SERIAL PRIMARY KEY ,
                data TEXT NOT NULL
                );
                """;
//        String insert= """
//                INSERT INTO info (data)
//                VALUES
//                ('test1'),
//                ('test2'),
//                ('test3'),
//                ('test4');
//                """;
//        String update = """
//                   UPDATE info
//                   SET data = 'testtest'
//                   WHERE id = 5
//                """;
        String select = """
                SELECT * FROM info
                """;
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            //var execute = statement.executeUpdate(tableInfo);//этот метод может выполнить любую строку
            //var execute1 = statement.executeUpdate(insert);
            //var execute2 = statement.executeUpdate(update);
            //System.out.println(execute);
            //System.out.println(execute1);
            //System.out.println(execute2);
            ResultSet resultSet = statement.executeQuery(select);//используется для получения значений
            while (resultSet.next()){
                System.out.print(resultSet.getLong("id"));
                System.out.println(resultSet.getString("data"));
                System.out.println("-----");
            }


        }
    }
}
