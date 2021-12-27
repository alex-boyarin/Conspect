package JDBC;

import JDBC.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementExample {
    public static void main(String[] args) throws SQLException {
        int companyId=1;
        var result = getEmployeeId(companyId);
        System.out.println(result);
    }

    private static List<Integer> getEmployeeId(int companyId) throws SQLException {
        String sql = """
                SELECT id
                FROM employee
                WHERE company_id=?
                """;
        List<Integer> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, companyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.add(resultSet.getObject("id",Integer.class));
            }
        }return result;
    }
}
