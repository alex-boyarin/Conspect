package jdbc_example;

import java.sql.*;

//Подключение к БД
public class PostgreSqlExample {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "25091986";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("No postgres driver");
            return;
        }
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD );
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students ORDER BY student_id DESC");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("student_id") + " "+
                        resultSet.getString("name") + " " +
                        resultSet.getString("last_name") + " " +
                        resultSet.getString("average_grade"));
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
