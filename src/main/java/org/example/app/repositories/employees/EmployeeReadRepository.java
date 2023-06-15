package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeReadRepository {

    public List<Employee> readEmployee() {
        try (Statement stmt = DBConn.connect().createStatement()) {
            List<Employee> list = new ArrayList<>();
            String sql = "SELECT employees.id, lastName, firstName, birthDate, positions.id as positionId, positions.name as positionName, " +
                         "phone, salary FROM " +
                         Constants.TABLE_EMPLOYEES + " inner join positions on " +
                         "employees.positionId = positions.id";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String birthDate = rs.getString("birthDate");
                int positionId = rs.getInt("positionId");
                String positionName = rs.getString("positionName");
                String phone = rs.getString("phone");
                double salary = rs.getDouble("salary");
                Employee employee = new Employee(id, lastName, firstName, birthDate, positionId, positionName, phone, salary);
                list.add(employee);
            }
            return list;

        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
