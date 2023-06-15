package org.example.app.repositories.positions;

import org.example.app.database.DBConn;
import org.example.app.entities.Position;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositionReadRepository {

    List<Position> list;

    public List<Position> readPositions() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, name FROM " + Constants.TABLE_POSITIONS;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Position position = new Position(id, name);
                list.add(position);
            }
            // Возвращаем коллекцию данных
            return list;
        } catch (SQLException e) {
            // Если ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }

    public void checkById(int id) {
        String sql = "SELECT id FROM " + Constants.TABLE_POSITIONS + " WHERE id=(?);";
        try (PreparedStatement stmt = DBConn.connect().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            System.out.println("Position Id " + id + " not found");
        }
    }

    public void checkByName(String name) {
        String sql = "SELECT name FROM " + Constants.TABLE_POSITIONS + " WHERE name=?";
        try (PreparedStatement stmt = DBConn.connect().prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            System.out.println("Position Name " + name + " not found");
        }
    }

    public Position findFirstByName(String name) {
        String sql = "SELECT id,name FROM " + Constants.TABLE_POSITIONS + " WHERE name=?";
        try (PreparedStatement stmt = DBConn.connect().prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return null;
            } else {
                return new Position(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            System.out.println("Position Name " + name + " not found");
            return null;
        }
    }
}
