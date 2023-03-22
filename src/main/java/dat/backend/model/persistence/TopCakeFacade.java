package dat.backend.model.persistence;

import dat.backend.model.entities.TopCake;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class TopCakeFacade {

    static ArrayList<TopCake>topCakeList(ConnectionPool connectionPool) throws DatabaseException {
       return TopCakeMapper.toppingList(connectionPool);
    }
}
