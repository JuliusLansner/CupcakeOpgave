package dat.backend.model.persistence;

import dat.backend.model.entities.BottomCake;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class BottomCakeFacade {

    static ArrayList<BottomCake>bottomlist(ConnectionPool connectionPool) throws DatabaseException {
        return BottomCakeMapper.bottomList(connectionPool);
    }
}
