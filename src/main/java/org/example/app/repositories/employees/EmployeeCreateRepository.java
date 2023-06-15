package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.entities.Position;
import org.example.app.repositories.positions.PositionReadRepository;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeCreateRepository {
    private final PositionReadRepository positionReadRepository;

    public EmployeeCreateRepository(PositionReadRepository positionReadRepository) {
        this.positionReadRepository = positionReadRepository;
    }

    public String createEmployee(Employee employee) {
        if (employee.getPositionId() != null) {
            return execute(employee);
        } else {
            Position firstByName = positionReadRepository.findFirstByName(employee.getPositionName());
            if (firstByName == null) {
                return "Name not found";
            } else {
                employee.setPositionId(firstByName.getId());
                return execute(employee);
            }
        }
    }

    private String execute(Employee employee) {
        String sql = "INSERT INTO " + Constants.TABLE_EMPLOYEES +
                     "(lastName, firstName, birthDate, positionId, phone, salary)" +
                     " VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, employee.getLastName());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getBirthDate());
            pstmt.setInt(4, employee.getPositionId());
            pstmt.setString(5, employee.getPhone());
            pstmt.setDouble(6, employee.getSalary());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
