package dat.backend.model.persistence;

import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {

    static void createProduct(ConnectionPool connectionPool, String top, String bottom, int price, int orderid, int amount) throws DatabaseException {
        String sql = "INSERT INTO produkt(top, bund, pris, ordreid, antal) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, top);
            pre.setString(2, bottom);
            pre.setInt(3, price);
            pre.setInt(4, orderid);
            pre.setInt(5, amount);
            pre.executeUpdate();
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error executing SQL statement: " + sql);
        }
    }

}