package dat.backend.model.persistence;

import dat.backend.model.entities.TopCake;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

public class TopCakeFacade {


    public static ArrayList<TopCake>topCakeList() throws DatabaseException, SQLException {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.getConnection();
       return TopCakeMapper.toppingList(connectionPool);
    }
}
