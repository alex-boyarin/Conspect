package jdbc_example;

import jdbc_example.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Взяв за основу пример, написать программу, которая выводит всех учеников, относящихся к конкретному классу,
//а также рассчитывает средний балл всех учеников в этом классе.
public class PreparedStatementExample {
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
        String selectRequest = "INSERT INTO students ( name, last_name, average_grade) VALUES ( ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(selectRequest)) {

            System.out.println("Select and put into Object:");

            ResultSet resultSet = selectFromDB(statement, "students", "id", "name", "last_name", "average_grade");
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int studentId = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                double averageGrade = Double.parseDouble(resultSet.getString("average_grade"));
                students.add(new Student(studentId, name, lastName, averageGrade));
            }
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Insert new student");
            String name = "Witya";
            String lastName = "Ivanov";
            double averageGrade = 8.8;
            //параметры передаются в таком же порядке как указано в таблице
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setDouble(3, averageGrade);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    //              ТАК ЛУЧШЕ НЕ ДЕЛАТЬ!!! Не безопасно!!!
    private static ResultSet selectFromDB(Statement statement, String tableName, String... columns) throws SQLException {
        String req = Arrays.toString(columns);
        String strStatement = "SELECT " + req.substring(1, req.length() - 1) + " FROM " + tableName;
        System.out.println(strStatement);
        return statement.executeQuery(strStatement);
    }
}
