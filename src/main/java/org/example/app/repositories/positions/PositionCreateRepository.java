package org.example.app.repositories.positions;

import org.example.app.database.DBConn;
import org.example.app.entities.Position;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PositionCreateRepository {

    public String createPosition(Position position) {
        String sql = "INSERT INTO " + Constants.TABLE_POSITIONS + "(name) VALUES(?)";
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, position.getName());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
