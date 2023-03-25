package dat.backend.model.persistence;

import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;

public class ProduktFacade {

    public static void createProduct(String top, String bottom, int price, int orderid, String amount){
        ConnectionPool connectionPool = new ConnectionPool();
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ProductMapper.createProduct(connectionPool,top,bottom,price,orderid,amount);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

}
