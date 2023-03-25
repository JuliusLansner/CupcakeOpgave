package dat.backend.model.persistence;

import dat.backend.model.entities.Ordre;
import dat.backend.model.entities.Product;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;

public class ProductMapper {

    public static int createProduct(ConnectionPool connectionPool, String top, String bottom, int price, int orderid, String amount) {
        String sql = "INSERT INTO produkt(top, bund, pris, ordreid, antal) VALUES (?, ?, ?, ?, ?)";
        ResultSet generatedKeys = null;
        int productId = -1; // initialize with -1 to indicate error condition

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pre.setString(1, top);
            pre.setString(2, bottom);
            pre.setInt(3, price);
            pre.setInt(4, orderid);
            pre.setInt(5, Integer.parseInt(amount));
            pre.executeUpdate();

            generatedKeys = pre.getGeneratedKeys();
            while (generatedKeys.next()){
                productId = generatedKeys.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(); // Print stack trace for debugging purposes
        } finally {
            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Print stack trace for debugging purposes
                }
            }
        }

        return productId;
    }


    static Product findProduct(ConnectionPool connectionPool,int productId) throws DatabaseException {
        String sql ="SELECT * FROM cupcake.produkt WHERE produktid = "+productId;
        Product product = null;

        try(Connection connection = connectionPool.getConnection()){

            try(PreparedStatement pre = connection.prepareStatement(sql)){
                ResultSet rs = pre.executeQuery(); //Laver resultset baseret på ordre fra databasen

                while(rs.next()){
                    int produktid = rs.getInt(1);
                    String top = rs.getString(2);
                    String bottom = rs.getString(3);
                    int price = rs.getInt(4);
                    int orderid = rs.getInt(5);
                    int amount = rs.getInt(6);

                    product = new Product(produktid,top,bottom,price,orderid,amount);
                }
            }catch (SQLException ex){
                throw new DatabaseException(ex, "Something with the sql or the java syntax is wrong");
            }

        }catch(SQLException e){
            throw new DatabaseException(e, "Error logging in. Something went wrong with the database");
        }
        return product;
    }



}
