package dat.backend.model.persistence;

import dat.backend.model.entities.Ordre;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class OrdreFacade {

    public static ArrayList<Ordre> getOrdrelist(ConnectionPool connectionPool) throws DatabaseException {
        return OrdreMapper.ordreliste(connectionPool);
    }
}
