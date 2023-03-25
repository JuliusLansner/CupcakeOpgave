package dat.backend.model.persistence;

import dat.backend.model.entities.Product;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;

public class ProduktFacade {

    public static int createProduct(String top, String bottom, int price, int orderid, String amount){
        ConnectionPool connectionPool = new ConnectionPool();
        int id = 0;
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        id = ProductMapper.createProduct(connectionPool,top,bottom,price,orderid,amount);
        return id;
    }

    public static Product findProduct(int productId){
        ConnectionPool connectionPool = new ConnectionPool();
        Product product = null;
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            product = ProductMapper.findProduct(connectionPool,productId);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

     return product;
    }



}
